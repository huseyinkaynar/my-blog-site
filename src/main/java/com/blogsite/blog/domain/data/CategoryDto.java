package com.blogsite.blog.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
@Getter
@Setter
public class CategoryDto extends BaseDto{
    private String title;
    private String metaTitle;
    private String slug;
    private String content;

    @JsonIgnoreProperties("categories")
    private List<PostDto> posts;

}
