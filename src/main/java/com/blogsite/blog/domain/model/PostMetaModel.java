package com.blogsite.blog.domain.model;

import com.blogsite.blog.domain.constant.DomainConstant;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author hkaynar on 09.12.2021
 */
@Entity
@Table(name = DomainConstant.POST_META_TABLE_NAME)
@Getter
public class PostMetaModel extends ItemModel {
    public static final String KEY = "key";
    public static final String CONTENT = "content";
    public static final String POST = "post";

    private String key;

    private String content;


    @ManyToOne
    private PostModel  post;

    public void setKey(String key) {
        addChangeAttribute(PostMetaModel.KEY);
        this.key = key;
    }

    public void setContent(String content) {
        addChangeAttribute(PostMetaModel.CONTENT);
        this.content = content;
    }

    public void setPost(PostModel post) {
        addChangeAttribute(PostMetaModel.POST);
        this.post = post;
    }
}
