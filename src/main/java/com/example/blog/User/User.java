package com.example.blog.User;

import com.example.blog.Comment.Comment;
import com.example.blog.Post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
//import io.crnk.core.resource.annotations.JsonApiId;
//import io.crnk.core.resource.annotations.JsonApiResource;

//import javax.persistence.*;

import java.util.List;

//import static javax.persistence.GenerationType.SEQUENCE;

@DynamoDbBean
public class User {

    private String pk;
    private String sk;

    private String id;
    private String name;
    private String email;

    public User(String pk, String sk, String id, String name, String email) {
        this.pk = pk;
        this.sk = sk;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {

    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute("PK")
    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("SK")
    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User setKeys(String id, User user){
        user.setPk("user#"+id);
        user.setSk("user#"+id);
        return user;
    }
}
