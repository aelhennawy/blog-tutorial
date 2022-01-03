package com.example.blog.Post;

import com.example.blog.User.User;
import com.example.blog.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getALl(){
        return postRepository.findAll();
    }

    public void createPost(PostRequest post){
        User user = userService.getById(post.getUser_id());
        Post new_post = new Post();
        new_post.setTitle(post.getTitle());
        new_post.setBody(post.getBody());
        new_post.setUser(user);

        postRepository.save(new_post);
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).get();
    }
}
