package com.example.blog.Post;

import com.example.blog.User.User;
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

        postRepository.save(post);
    }

    public Iterator<Post> getUserPosts(String id) {
        return postRepository.getUserPosts(id);
    }

    public List<Post> filterByDate(String startDate, String endDate){
        return postRepository.filterByDate(startDate, endDate);
    }
}
