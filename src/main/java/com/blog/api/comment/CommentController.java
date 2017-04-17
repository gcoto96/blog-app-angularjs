package com.blog.api.comment;

import com.blog.model.comment.Comment;
import com.blog.model.post.Post;
import com.blog.pojo.CommentRest;
import com.blog.pojo.PostRest;
import com.blog.dao.CommentDAO;
import com.blog.repository.comment.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by nasheikh on 4/9/17.
 * Class Name: CommentController
 * Description: REST controller for all comment related workflow
 */
@RestController
@RequestMapping(value = "/comments", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

    @Autowired private JdbcTemplate jdbcTemplate;

    @Autowired
    private CommentRepo repo;
    @Autowired
    private CommentDAO commentDAO;

/*
   Method Name: addComment
   Description : This method is to save comments by user on blog
   Input Param : CommentRest
   Output Type: CommentRest
 */
    @RequestMapping(method = RequestMethod.POST)
    public CommentRest addComment(@Valid @RequestBody CommentRest comment) {
        CommentRest res = commentDAO.saveComment(comment);
        return res;
    }

//TODO Following are currently unused REST endpoints

//    @RequestMapping(method = RequestMethod.GET)
//    public List<CommentRest> findComment() {
//      //  return repo.findAll();
//    }

//    @RequestMapping(value = "/{commentId}", method=RequestMethod.GET)
//    public CommentRest getComment(@PathVariable Integer commentId){
//      //  Post qry = new Post();
//        //if (postId != null)
//      //  return repo.findOne(commentId);
//
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Comment updateComment(@RequestBody Comment updatedItem, @PathVariable Integer id) {
//        updatedItem.setId(id);
//        return repo.saveAndFlush(updatedItem);
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void deleteComment(@PathVariable Integer id) {
//        repo.delete(id);
//    }
}
