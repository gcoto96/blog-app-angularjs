package com.blog.dao;

import com.blog.model.comment.Comment;
import com.blog.model.post.Post;
import com.blog.pojo.CommentRest;
import com.blog.pojo.PostRest;
import com.blog.repository.comment.CommentRepo;
import com.blog.repository.post.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by nasheikh on 4/16/17.
 */
@Service
public class PostDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PostRepo repo;

    public PostRest savePost(PostRest post){
        Post postModel = new Post();
        postModel.setContent(post.getContent());
        postModel.setAuthor(post.getAuthor());
        postModel.setTitle(post.getTitle());
        postModel.setImage(post.getImage());
        repo.save(postModel);
        return post;
    }
}
