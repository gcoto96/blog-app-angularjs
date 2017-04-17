package com.blog.model.account;

/**
 * Created by nasheikh on 4/8/17.
 */
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
