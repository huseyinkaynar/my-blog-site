package com.blogsite.blog.service;

import com.blogsite.blog.domain.data.PostDto;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
public interface PostService {
    List<PostDto> getPosts();

    PostDto getPost(Long id);

    void save(PostDto postDto);

    void update(PostDto postDto, Long id);

    void delete(Long id);
}
