package com.blog.api.post;

import com.blog.dao.CommentDAO;
import com.blog.dao.PostDAO;
import com.blog.model.comment.Comment;
import com.blog.model.post.Post;
import com.blog.pojo.PostRest;
import com.blog.repository.post.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private PostDAO postDAO;

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> findPost() {
       return repo.findAll();
    }

    @RequestMapping(value = "/{postId}", method=RequestMethod.GET)
    public Post getOrder(@Valid @PathVariable Integer postId){

        return repo.findOne(postId);

    }

    @RequestMapping(method = RequestMethod.POST)
    public PostRest addPost(@Valid @RequestBody PostRest post) {
        PostRest res = postDAO.savePost(post);
        return res;


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
