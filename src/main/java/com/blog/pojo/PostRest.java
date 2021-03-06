package com.blog.pojo;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * Created by nasheikh on 4/16/17.
 * Class Name: PostRest
 * Description: REST to DAO mapper
 */
public class PostRest {

    private Integer id;

    @NotNull(message = "title is required")
    private String title;

    @NotNull(message = "content is required")
    private String content;

    @NotNull(message = "author is required")
    private String author;

    private String image;

    public PostRest(Integer id, String title, String content, String author, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.image = image;
    }
    public PostRest(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
