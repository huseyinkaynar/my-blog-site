package com.blogsite.blog.domain.data;

import lombok.Data;

/**
 * @author hkaynar on 12.12.2021
 */
@Data
public class PostMetaDto {

    private String key;

    private String content;

    private PostDto post;
}
