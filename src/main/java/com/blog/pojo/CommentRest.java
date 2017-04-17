package com.blog.pojo;

import com.blog.model.post.Post;

import javax.validation.constraints.NotNull;


/**
 * Created by nasheikh on 4/16/17.
 */
public class CommentRest {

    @NotNull(message = "content is required")
    private String content;

    @NotNull(message = "author is required")
    private String author;

    @NotNull(message = "postId is required")
    private int postId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }


}
