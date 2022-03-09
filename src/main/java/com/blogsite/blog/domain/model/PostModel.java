package com.blogsite.blog.domain.model;

import com.blogsite.blog.domain.constant.DomainConstant;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * @author hkaynar on 09.12.2021
 */
@Entity
@Table(name = DomainConstant.POST_TABLE_NAME)
@Getter
public class PostModel extends ItemModel {

    public static final String TITLE = "title";
    public static final String METATITLE = "metaTitle";
    public static final String SLUG = "slug";
    public static final String CONTENT = "content";
    public static final String PUBLISHEDAT = "publishedAt";
    public static final String PUBLISHED = "published";
    public static final String SUMMARY = "summary";
    public static final String AUTHORID = "authorId";
    public static final String PARENTID = "parentId";
    public static final String CATEGORIES = "categories";
    public static final String TAGS = "tags";
    public static final String USER = "user";
    public static final String POSTCOMMENTS = "postComments";
    public static final String POSTMETAS = "postMetas";


    private String authorId;
    private String parentId;
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private String published;
    private LocalDateTime publishedAt;

    private String content;

    @ManyToMany
    private Set<CategoryModel> categories;

    @ManyToMany
    private Set<TagModel> tags;

    @ManyToOne
    private UserModel user;

    @OneToMany
    private Set<PostCommentModel> postComments;

    @OneToMany
    private Set<PostMetaModel> postMetas;



    public void setTitle(String title) {
        addChangeAttribute(PostModel.TITLE);
        this.title = title;
    }

    public void setMetaTitle(String metaTitle) {
        addChangeAttribute(PostModel.METATITLE);
        this.metaTitle = metaTitle;
    }

    public void setSlug(String slug) {
        addChangeAttribute(PostModel.SLUG);
        this.slug = slug;
    }

    public void setContent(String content) {
        addChangeAttribute(PostModel.CONTENT);
        this.content = content;
    }

    public void setSummary(String summary) {
        addChangeAttribute(PostModel.SUMMARY);
        this.summary = summary;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        addChangeAttribute(PostModel.PUBLISHEDAT);
        this.publishedAt = publishedAt;
    }

    public void setAuthorId(String authorId) {
        addChangeAttribute(PostModel.AUTHORID);
        this.authorId = authorId;
    }

    public void setParentId(String parentId) {
        addChangeAttribute(PostModel.PARENTID);
        this.parentId = parentId;
    }

    public void setCategories(Set<CategoryModel> categories) {
        addChangeAttribute(PostModel.CATEGORIES);
        this.categories = categories;
    }

    public void setTags(Set<TagModel> tags) {
        addChangeAttribute(PostModel.TAGS);
        this.tags = tags;
    }

    public void setUser(UserModel user) {
        addChangeAttribute(PostModel.USER);
        this.user = user;
    }
    public void setPostComments(Set<PostCommentModel> postComments) {
        addChangeAttribute(PostModel.POSTCOMMENTS);
        this.postComments = postComments;
    }
    public void setPostMetas(Set<PostMetaModel> postMetas) {
        addChangeAttribute(PostModel.POSTMETAS);
        this.postMetas = postMetas;
    }
}
