package com.example.blog.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Repository
public class UserRepository {

    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    //Get users using base table, filter results using SK begins_with user#
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

    private DynamoDbTable<User> getTable() {
        return dynamoDbEnhancedClient.table("Blog",
                TableSchema.fromBean(User.class));
    }
}
