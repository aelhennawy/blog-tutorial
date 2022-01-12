package com.example.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class BlogService {
    @Autowired
    BlogRepository repository;

    public void createTable(){
        repository.createTable();
    }

    public void createBlog(Blog blog){
        repository.save(blog);
    }

    public Blog updateBlog(Blog blog){
        return repository.update(blog);
    }

    public Iterator<Blog> getAll() {
        return repository.getAllBlogs();
    }

    public Blog getOne(String id) {
        return repository.getBlog(id);
    }
}
