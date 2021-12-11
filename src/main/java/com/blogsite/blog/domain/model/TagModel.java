package com.blogsite.blog.domain.model;

import com.blogsite.blog.domain.constant.DomainConstant;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author hkaynar on 09.12.2021
 */
@Entity
@Table(name = DomainConstant.TAG_TABLE_NAME)
@Getter
public class TagModel extends ItemModel {
    public static final String TITLE = "title";
    public static final String METATITLE = "metaTitle";
    public static final String SLUG = "slug";
    public static final String CONTENT = "content";
    public static final String POSTS = "posts";


    private String title;
    private String metaTitle;
    private String slug;
    @Lob
    private String content;


    @ManyToMany(mappedBy = "tags")
    private List<PostModel> posts;

    public void setTitle(String title) {
        addChangeAttribute(TagModel.TITLE);
        this.title = title;
    }

    public void setMetaTitle(String metaTitle) {
        addChangeAttribute(TagModel.METATITLE);
        this.metaTitle = metaTitle;
    }

    public void setSlug(String slug) {
        addChangeAttribute(TagModel.SLUG);
        this.slug = slug;
    }

    public void setContent(String content) {
        addChangeAttribute(TagModel.CONTENT);
        this.content = content;
    }

    public void setPosts(List<PostModel> posts) {
        addChangeAttribute(TagModel.POSTS);
        this.posts = posts;
    }
}
