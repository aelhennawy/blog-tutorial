package com.example.blog.Post;

import com.example.blog.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

import java.util.*;

@Repository
public class PostRepository {

    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    //Get posts using posts GSI
    public List<Post> getAll() {
        DynamoDbTable<Post> table = getTable();

        DynamoDbIndex<Post> index = getTable().index("posts");

        ScanEnhancedRequest scanEnhancedRequest = ScanEnhancedRequest
                .builder()
                .build();

        Iterator<Page<Post>> result = index.scan(scanEnhancedRequest).iterator();
        List<Post> postList = new ArrayList<>();

        while (result.hasNext()) {
            Page<Post> post = result.next();
            postList.addAll(post.items());
        }

        return postList;
    }

    //Get posts using posts GSI, filter result using GSI SK(post_date)
    public List<Post> filterByDate(String startDate, String endDate){
        List<Post> postList = new ArrayList<>();
        DynamoDbTable<Post> table = getTable();
        DynamoDbIndex<Post> index = getTable().index("posts");

        AttributeValue startDateValue = AttributeValue.builder()
                .s(startDate).build();
        AttributeValue endDateValue = AttributeValue.builder()
                .s(endDate).build();

        Map<String, AttributeValue> attVal = new HashMap<>();
        attVal.put(":start_date", startDateValue);
        attVal.put(":end_date", endDateValue);

        Expression expression = Expression.builder()
                .expression("post_date between :start_date and :end_date")
                .expressionValues(attVal)
                .build();

        ScanEnhancedRequest scanEnhancedRequest = ScanEnhancedRequest
                .builder()
                .filterExpression(expression)
                .build();

        for (Page<Post> post : index.scan(scanEnhancedRequest)) {
            postList.addAll(post.items());
        }

        return postList;
    }

    public void save(Post post) {
        DynamoDbTable<Post> table = getTable();
        table.putItem(post);
    }

    //Get posts using base table, filter results on PK=user_id and SK begin_with post
    public Iterator<Post> getUserPosts(String id) {
        DynamoDbTable<Post> blogTable = getTable();

        Key sortKey = Key.builder().partitionValue("user#"+id).sortValue("post#").build();

        QueryConditional queryConditional = QueryConditional.sortBeginsWith(sortKey);

        return blogTable.query(queryConditional).items().iterator();
    }

    private DynamoDbTable<Post> getTable() {
        return dynamoDbEnhancedClient.table("Blog",
                TableSchema.fromBean(Post.class));
    }
}
