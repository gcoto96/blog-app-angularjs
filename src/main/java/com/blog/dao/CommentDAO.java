package com.blog.dao;

import com.blog.model.comment.Comment;
import com.blog.model.post.Post;
import com.blog.pojo.CommentRest;
import com.blog.repository.comment.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nasheikh on 4/16/17.
 */
@Service
public class CommentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CommentRepo repo;

    public CommentRest saveComment(CommentRest comment){
        Post post = new Post();
        post.setId(comment.getPostId());

        Comment commentModel = new Comment();
        commentModel.setPost(post);
        commentModel.setAuthor(comment.getAuthor());
        commentModel.setContent(comment.getContent());
        repo.save(commentModel);
        return comment;
    }
}
