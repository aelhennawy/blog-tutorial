package com.example.blog.User;

import com.example.blog.Comment.Comment;
import com.example.blog.Post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.crnk.core.resource.annotations.JsonApiId;
//import io.crnk.core.resource.annotations.JsonApiResource;

//import javax.persistence.*;

import java.util.List;

//import static javax.persistence.GenerationType.SEQUENCE;

//@Entity(name = "User")
//@Table(
//        name = "users",
//        uniqueConstraints = {
//                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
//        }
//)
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(
//            nullable = false
//    )
//    private String name;
//
//    @Column(
//            nullable = false
//    )
//    private String email;
//
//    @OneToMany(mappedBy = "user")
//    @JsonIgnore
//    private List<Post> posts;
//
//    @OneToMany(mappedBy = "user")
//    @JsonIgnore
//    private List<Comment> comments;
//
//
//    public User(Long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
//
//    public User() {
//
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }
//
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }
}
