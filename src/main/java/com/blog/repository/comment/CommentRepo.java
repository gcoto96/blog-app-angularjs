package com.blog.repository.comment;

import com.blog.model.comment.Comment;
import com.blog.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nasheikh on 4/9/17.
 */
public interface CommentRepo extends JpaRepository<Comment, Integer> {
    Comment save(Post e);
}
