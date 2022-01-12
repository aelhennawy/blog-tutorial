package com.example.blog;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Iterator;

@Repository
public class BlogRepository {

    @Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public void save(Blog blog){
        DynamoDbTable<Blog> blogTable = getTable();
        blogTable.putItem(blog);
    }

    public Blog update(Blog blog){
        DynamoDbTable<Blog> blogTable = getTable();
        return blogTable.updateItem(blog);
    }

    public Blog getBlog(String id){
        DynamoDbTable<Blog> blogTable = getTable();
        Key key = Key.builder().partitionValue(id).build();

        return (Blog) blogTable.getItem(key);
    }

    public Iterator<Blog> getAllBlogs(){
        DynamoDbTable<Blog> blogTable = getTable();

        return blogTable.scan().items().iterator();
    }

    public void createTable(){
        DynamoDbTable<Blog> blogTable = getTable();
        blogTable.createTable();
    }


    private DynamoDbTable<Blog> getTable(){

        return dynamoDbEnhancedClient.table("Blog",
                TableSchema.fromBean(Blog.class));
    }

}
