package com.example.blog.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAll(){
        return postService.getALl();
    }

    @PostMapping()
    public void createPost(@RequestBody PostRequest post){
        postService.createPost(post);
    }
}
