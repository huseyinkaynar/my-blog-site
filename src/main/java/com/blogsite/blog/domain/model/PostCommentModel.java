package com.blogsite.blog.domain.model;

import com.blogsite.blog.domain.constant.DomainConstant;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author hkaynar on 09.12.2021
 */
@Entity
@Table(name = DomainConstant.POST_COMMENT_TABLE_NAME)
@Getter
public class PostCommentModel extends ItemModel {

    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String CREATEDAT = "createdAt";
    public static final String PUBLISHEDAT = "publishedAt";
    public static final String PUBLISHED = "published";
    public static final String POST = "post";



    private String title;
    private String published;
    private LocalDateTime createdAt;
    private LocalDateTime publishedAt;

    private String content;

    @ManyToOne
    private PostModel post;

    public void setTitle(String title) {
        addChangeAttribute(PostCommentModel.TITLE);
        this.title = title;
    }

    public void setPublished(String published) {
        addChangeAttribute(PostCommentModel.PUBLISHED);
        this.published = published;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        addChangeAttribute(PostCommentModel.CREATEDAT);
        this.createdAt = createdAt;
    }

    public void setContent(String content) {
        addChangeAttribute(PostCommentModel.CONTENT);
        this.content = content;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        addChangeAttribute(PostCommentModel.PUBLISHEDAT);
        this.publishedAt = publishedAt;
    }

    public void setPost(PostModel post) {
        addChangeAttribute(PostCommentModel.POST);
        this.post = post;
    }
}
