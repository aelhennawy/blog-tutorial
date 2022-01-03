package com.example.blog.Post;

public class PostRequest {

    private String title;
    private String body;
    private Long user_id;

    public PostRequest(String title, String body, Long user_id) {
        this.title = title;
        this.body = body;
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
