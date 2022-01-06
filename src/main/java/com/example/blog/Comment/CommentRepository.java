package com.example.blog.Comment;

import com.example.blog.Post.Post;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface CommentRepository extends CrudRepository<Comment, Long> {

//    List<Comment> findCommentByPost(Post post);

}
