package com.example.blog.Comment;

import com.example.blog.Post.Post;
import com.example.blog.Post.PostService;
import com.example.blog.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    public List<Comment> getAllComments(Long post_id) {
        Post post = postService.getPost(post_id);
        return commentRepository.findCommentByPost(post);
    }

    public void addComment(Long post_id, CommentRequest comment) {
        Post post = postService.getPost(post_id);

        Comment new_comment = new Comment();
        new_comment.setBody(comment.getBody());
        new_comment.setPost(post);
        new_comment.setUser(userService.getById(comment.getUser_id()));

        commentRepository.save(new_comment);
    }

}
