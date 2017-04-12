package com.blog.model.post;

/**
 * Created by nasheikh on 4/9/17.
 */
import com.blog.model.comment.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "posts")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
    generator = "postIdGen")
    @SequenceGenerator(name = "postIdGen",
            sequenceName = "POST_ID_SEQ")
    private Integer id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String author;

    @Column
    private String image;

//
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Comment> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}