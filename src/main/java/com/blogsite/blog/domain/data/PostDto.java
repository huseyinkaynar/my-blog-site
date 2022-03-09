package com.blogsite.blog.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author hkaynar on 12.12.2021
 */
@Getter
@Setter
public class PostDto extends BaseDto {
    private String authorId;
    private String parentId;
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private String published;
    private LocalDateTime publishedAt;
    private String content;

    @JsonIgnoreProperties("posts")
    private Set<CategoryDto> categories;
    @JsonIgnoreProperties("posts")
    private Set<TagDto> tags;

    private UserDto user;

    private Set<PostCommentDto> postComments;

    private Set<PostMetaDto> postMetas;
}
