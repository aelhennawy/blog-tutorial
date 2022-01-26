package com.example.blog.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;

import java.util.Iterator;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getAll() {
        return postRepository.getAll();
    }

    public void create(Post post) {
        post.setKeys(post.getId(), post);

        System.out.println(post.getPk());
        System.out.println(post.getSk());
        System.out.println(post.getUser_id());

        postRepository.save(post);
    }
}
