package com.example.blog.User;

import com.example.blog.Blog.Post;
import com.example.blog.Blog.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    @Autowired
    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public void creatUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PostMapping("{user_id}/posts")
    public void createPost(@PathVariable("user_id") Long id, @RequestBody Post post){
        postService.createPost(post, id);
    }

}
