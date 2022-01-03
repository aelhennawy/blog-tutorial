package com.example.blog.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts/{post_id}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@PathVariable("post_id") Long post_id){
        return commentService.getAllComments(post_id);
    }

    @PostMapping()
    public void addComment(@PathVariable("post_id") Long post_id, @RequestBody CommentRequest comment){
        commentService.addComment(post_id, comment);
    }
}
