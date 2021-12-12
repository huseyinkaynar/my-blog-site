package com.blogsite.blog.domain.data;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
@Data
public class PostDto {
    private String authorId;
    private String parentId;
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private String published;
    private LocalDateTime publishedAt;
    private String content;

    private List<CategoryDto> categories;

    private List<TagDto> tags;

    private UserDto user;

    private List<PostCommentDto> postComments;

    private List<PostMetaDto> postMetas;
}
