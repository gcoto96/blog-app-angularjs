package com.blog.repository.post;

import com.blog.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by nasheikh on 4/9/17.
 */
public interface PostRepo extends JpaRepository<Post, Integer> {
    Post save(Post e);
    public List<Post> findAll();
}
