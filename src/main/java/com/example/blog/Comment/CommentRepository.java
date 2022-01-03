package com.example.blog.Comment;

import com.example.blog.Post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentByPost(Post post);

}
