package com.blogsite.blog.domain.model;

import com.blogsite.blog.domain.constant.DomainConstant;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author hkaynar on 09.12.2021
 */
@Entity
@Table(name = DomainConstant.USER_TABLE_NAME)
@Getter
public class UserModel extends ItemModel {
    public static final String EMAIL = "email";
    public static final String FIRSTNAME = "firstName";
    public static final String LASTNAME = "lastName";
    public static final String PASSWORD = "password";
    public static final String POSTS = "posts";

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany
    private List<PostModel> posts;

    public void setFirstName(String firstName) {
        addChangeAttribute(UserModel.FIRSTNAME);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        addChangeAttribute(UserModel.LASTNAME);
        this.lastName = lastName;
    }
    public void setPassword(String password) {
        addChangeAttribute(UserModel.PASSWORD);
        this.password = password;
    }
    public void setEmail(String email) {
        addChangeAttribute(UserModel.EMAIL);
        this.email = email;
    }
    public void setPosts(List<PostModel> posts) {
        addChangeAttribute(UserModel.EMAIL);
        this.posts = posts;
    }
}
