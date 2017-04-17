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
 * Class Name: PostController
 * Description: REST controller for all post related workflow
 */

@RestController
@RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PostRepo repo;

    @Autowired
    private PostDAO postDAO;

    /*
       Method Name: findAllPosts
       Description : This method is to fetch all blog posts
       Input Param : NA
       Output Type: List of Post
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Post> findAllPosts() {
        //TODO apply pagination
        return repo.findAll();
    }


    /*
       Method Name: getPost
       Description : This method is to fetch details of blog posts
       Input Param : postId @Integer
       Output Type: Post
     */
    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    public Post getPost(@Valid @PathVariable Integer postId) {

        return repo.findOne(postId);

    }

    /*
          Method Name: addPost
          Description : This method is to add blog posts
          Input Param : PostRest
          Output Type: PostRest
    */
    @RequestMapping(method = RequestMethod.POST)
    public PostRest addPost(@Valid @RequestBody PostRest post) {
        PostRest res = postDAO.savePost(post);
        return res;


    }

//TODO Below are unused methods will be exposed soon

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Post updatePost(@RequestBody Post updatedItem, @PathVariable Integer id) {
//        updatedItem.setId(id);
//        return repo.saveAndFlush(updatedItem);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void deletePost(@PathVariable Integer id) {
//        repo.delete(id);
//    }
}
