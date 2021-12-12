package com.blogsite.blog.domain.data;

import lombok.Data;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
@Data
public class TagDto {
    private String title;
    private String metaTitle;
    private String slug;
    private String content;
    private List<PostDto> posts;
}
