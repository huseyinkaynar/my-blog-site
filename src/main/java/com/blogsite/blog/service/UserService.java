package com.blogsite.blog.service;

import com.blogsite.blog.domain.data.UserDto;

import java.util.List;

/**
 * @author hkaynar on 11.12.2021
 */
public interface UserService {

    List<UserDto> getUsers();

    UserDto getUser(Long id);

    void save(UserDto userDto);

    void update(UserDto userDto, Long id);

    void delete(Long id);
}
