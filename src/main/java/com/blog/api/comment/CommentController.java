package com.blog.api.comment;

import com.blog.model.comment.Comment;
import com.blog.model.post.Post;
import com.blog.repository.comment.CommentRepo;
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
@RequestMapping(value = "/comments", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired
    private CommentRepo repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> findComment() {
        return repo.findAll();
    }

    @RequestMapping(value = "/{commentId}", method=RequestMethod.GET)
    public Comment getComment(@PathVariable Integer commentId){
      //  Post qry = new Post();
        //if (postId != null)
        return repo.findOne(commentId);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment) {
       return this.repo.save(comment);

    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Comment updateComment(@RequestBody Comment updatedItem, @PathVariable Integer id) {
//        updatedItem.setId(id);
//        return repo.saveAndFlush(updatedItem);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable Integer id) {
        repo.delete(id);
    }
}
