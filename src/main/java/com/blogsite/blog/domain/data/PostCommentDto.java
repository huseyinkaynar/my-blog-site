package com.blogsite.blog.domain.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hkaynar on 12.12.2021
 */
@Data
public class PostCommentDto {
    private String title;
    private String published;
    private LocalDateTime createdAt;
    private LocalDateTime publishedAt;
    private String content;

    private PostDto post;
}
