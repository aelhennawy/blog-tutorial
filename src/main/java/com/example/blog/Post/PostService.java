package com.example.blog.Post;

import com.example.blog.User.User;
import com.example.blog.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void createPost(Post post, Long user_id){
        User user = userService.getById(user_id);
        post.setUser(user);
        postRepository.save(post);
    }
}
