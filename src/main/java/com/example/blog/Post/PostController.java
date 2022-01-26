package com.example.blog.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAll(){
        return postService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Post post){
        postService.create(post);
    }
}
