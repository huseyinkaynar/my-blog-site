package com.blogsite.blog.service;

import com.blogsite.blog.domain.data.PostMetaDto;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
public interface PostMetaService {
    List<PostMetaDto> getPostMetas();

    PostMetaDto getPostMeta(Long id);

    void save(PostMetaDto postMetaDto);

    void update(PostMetaDto postMetaDto, Long id);

    void delete(Long id);
}
