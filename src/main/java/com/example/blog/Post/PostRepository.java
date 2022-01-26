package com.example.blog.Post;

import com.example.blog.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

import java.util.*;

@Repository
public class PostRepository {

    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    @Autowired
    private DynamoDbClient dynamoDbClient;

    public List<Post> getAll() {
        DynamoDbTable<Post> table = getTable();

        DynamoDbIndex<Post> index = getTable().index("posts");

//        AttributeValue attributeValue = AttributeValue.builder().s("post#").build();
//        Map<String, AttributeValue> map = new HashMap<>();
//        map.put(":val", attributeValue);
//
//        Map<String, String> myExp = new HashMap<>();
//        myExp.put("#SK", "SK");
//
//        Expression expression = Expression.builder()
//                .expressionNames(myExp)
//                .expressionValues(map)
//                .expression("begins_with(#SK, :val)")
//                .build();

        ScanEnhancedRequest scanEnhancedRequest = ScanEnhancedRequest
                .builder()
//                .filterExpression(expression)
                .build();

        Iterator<Page<Post>> result = index.scan(scanEnhancedRequest).iterator();
        List<Post> postList = new ArrayList<>();

        while (result.hasNext()) {
            Page<Post> post = result.next();
            postList.addAll(post.items());
        }

        return postList;
    }

    public void save(Post post) {
        DynamoDbTable<Post> table = getTable();
        table.putItem(post);
    }

    private DynamoDbTable<Post> getTable() {
        return dynamoDbEnhancedClient.table("Blog",
                TableSchema.fromBean(Post.class));
    }
}
