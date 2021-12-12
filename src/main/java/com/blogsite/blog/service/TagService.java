package com.blogsite.blog.service;

import com.blogsite.blog.domain.data.TagDto;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
public interface TagService {
    List<TagDto> getTags();

    TagDto getTag(Long id);

    void save(TagDto tagDto);

    void update(TagDto tagDto, Long id);

    void delete(Long id);
}
