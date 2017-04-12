package com.blog.api.post;

import com.blog.model.comment.Comment;
import com.blog.model.post.Post;
import com.blog.repository.post.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by nasheikh on 4/9/17.
 */
@RestController
@RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired
    private PostRepo repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> findPost() {
       return repo.findAll();
    }

    @RequestMapping(value = "/{postId}", method=RequestMethod.GET)
    public Post getOrder(@PathVariable Integer postId){
      //  Post qry = new Post();
        //if (postId != null)
        return repo.findOne(postId);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Post addPost(@RequestBody Post post) {
       return this.repo.save(post);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Post updatePost(@RequestBody Post updatedItem, @PathVariable Integer id) {
        updatedItem.setId(id);
        return repo.saveAndFlush(updatedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Integer id) {
        repo.delete(id);
    }
}
