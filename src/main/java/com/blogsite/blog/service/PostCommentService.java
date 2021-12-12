package com.blogsite.blog.service;

import com.blogsite.blog.domain.data.PostCommentDto;
import com.blogsite.blog.domain.data.PostDto;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
public interface PostCommentService {

    List<PostCommentDto> getPostComments();

    PostCommentDto getPostComment(Long id);

    void save(PostCommentDto postCommentDto);

    void update(PostCommentDto postCommentDto, Long id);

    void delete(Long id);
}
