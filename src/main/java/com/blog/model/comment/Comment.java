package com.blog.model.comment;

/**
 * Created by nasheikh on 4/9/17.
 */
import com.blog.model.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "comments")
public class Comment implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
    generator = "commentIdGen")
    @SequenceGenerator(name = "commentIdGen",
            sequenceName = "COMMENT_ID_SEQ")
    private Integer id;

    @Column
    private String content;

    @Column
    private String author;

    @JsonIgnore()
    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private Post post;

    public Post getPost() { return post; }

    public void setPost(Post post) {
        this.post = post;
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
}