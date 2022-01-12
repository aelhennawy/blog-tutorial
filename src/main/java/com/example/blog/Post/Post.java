package com.example.blog.Post;

import com.example.blog.Comment.Comment;
import com.example.blog.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.crnk.core.resource.annotations.JsonApiId;
//import io.crnk.core.resource.annotations.JsonApiResource;

//import javax.persistence.*;

import java.util.List;

//import static javax.persistence.GenerationType.SEQUENCE;

//@Entity(name = "Post")
//@Table(name = "posts")
public class Post {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(
//            nullable = false
//    )
//    private String title;
//
//    @Column(
//            columnDefinition = "TEXT",
//            nullable = false
//    )
//    private String body;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @OneToMany(mappedBy = "post")
//    @JsonIgnore
//    private List<Comment> comments;
//
//    public Post() { }
//
////    public Post(String title, String body, User user) {
////        this.title = title;
////        this.body = body;
////        this.user = user;
////    }
//
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
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
