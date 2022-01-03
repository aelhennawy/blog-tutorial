package com.example.blog.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("{post_id}")
    public Post getPost(@PathVariable("post_id") Long id){
        try{
            return postService.getPost(id);
        }
        catch (NoSuchElementException exception){
            throw new IllegalStateException("Not Found");
        }
    }

    @PostMapping
    public void createPost(@RequestBody PostRequest post){
        postService.createPost(post);
    }
}
