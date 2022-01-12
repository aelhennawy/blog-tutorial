package com.example.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
public class BlogController {
    @Autowired
    BlogService service;

    @PostMapping("blog")
    public void create(@RequestBody Blog blog){
//        System.out.println(blog.getId() + " - " + blog.getTitle());
        service.createBlog(blog);
    }

    @GetMapping("blog/create")
    public void createTable(){
        service.createTable();
    }

    @GetMapping("blog/{id}")
    public Blog getAll(@PathVariable("id") String id){
        return service.getOne(id);
    }

    @PutMapping("blog/{id}")
    public Blog update(@PathVariable("id") String id, @RequestBody Blog blog){
        return service.updateBlog(blog);
    }

    @GetMapping("blog")
    public Iterator<Blog> getAll(){
        return service.getAll();
    }
}
