package com.blogsite.blog.domain.data;

import lombok.Data;

import java.util.List;

/**
 * @author hkaynar on 11.12.2021
 */
@Data
public class UserDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private List<PostDto> posts;

}
