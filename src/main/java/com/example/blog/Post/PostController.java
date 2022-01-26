package com.example.blog.Post;

import com.example.blog.User.User;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
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

    @GetMapping("/user/{id}")
    public Iterator<Post> getByUser(@PathVariable("id") String id){
        return postService.getUserPosts(id);
    }

    @GetMapping("filter_by_date")
    public List<Post> filterByDate(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate){
        return postService.filterByDate(startDate, endDate);
    }
}
