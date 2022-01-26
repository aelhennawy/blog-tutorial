package com.example.blog.User;

import com.example.blog.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Repository
public class UserRepository {

    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public Iterator<User> getAll() {
        DynamoDbTable<User> blogTable = getTable();

        AttributeValue attributeValue = AttributeValue.builder().s("user#").build();
        Map<String, AttributeValue> map = new HashMap<>();
        map.put(":val", attributeValue);

        Map<String, String> mapExp = new HashMap<>();
        mapExp.put("#SK", "SK");

        Expression expression = Expression.builder()
                .expressionValues(map)
                .expressionNames(mapExp)
                .expression("begins_with(#SK, :val)")
                .build();

        ScanEnhancedRequest enhancedRequest = ScanEnhancedRequest.builder()
                .filterExpression(expression)
                .build();

        return blogTable.scan(enhancedRequest).items().iterator();
    }

    public void save(User user) {
        DynamoDbTable<User> blogTable = getTable();
        blogTable.putItem(user);
    }

    public User update(String id, User user) {
        DynamoDbTable<User> blogTable = getTable();
        blogTable.putItem(user);
        return user;
    }

    public void delete(User user) {
        DynamoDbTable<User> blogTable = getTable();
        blogTable.deleteItem(Key.builder().partitionValue(user.getPk()).sortValue(user.getSk()).build());
    }



    public void query() {
//        AttributeValue attributeValue = AttributeValue.builder().s("user#").build();
//        QueryConditional queryConditional = QueryConditional.
//                sortBeginsWith(Key.builder().sortValue(attributeValue).build());
//
//        SdkIterable<Page<User>> result = blogTable.query(QueryEnhancedRequest.builder().queryConditional(queryConditional).build());

    }

    private DynamoDbTable<User> getTable() {
        return dynamoDbEnhancedClient.table("Blog",
                TableSchema.fromBean(User.class));
    }

}
