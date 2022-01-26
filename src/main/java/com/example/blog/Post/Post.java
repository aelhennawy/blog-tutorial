package com.example.blog.Post;

import com.example.blog.Comment.Comment;
import com.example.blog.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;
//import io.crnk.core.resource.annotations.JsonApiId;
//import io.crnk.core.resource.annotations.JsonApiResource;

//import javax.persistence.*;

import java.util.List;

@DynamoDbBean
public class Post {

    private String pk;
    private String sk;

    private String id;
    private String title;
    private String body;
    private String date;
    private String user_id;


    public Post() {
    }

    public Post(String pk, String sk, String id, String title, String body) {
        this.pk = pk;
        this.sk = sk;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @DynamoDbAttribute("PK")
    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getSk() {
        return sk;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = {"posts"})
    @DynamoDbAttribute("SK")
    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbAttribute("post_title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDbAttribute("post_body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @DynamoDbSecondarySortKey(indexNames = {"posts"})
    @DynamoDbAttribute("post_date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @DynamoDbAttribute("post_user_id")
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Post setKeys(String id, Post post) {
        post.setPk("user#" + post.getUser_id());
        post.setSk("post#" + id);
        return post;
    }
}
