package com.blogsite.blog.service;

import com.blogsite.blog.domain.data.CategoryDto;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
public interface CategoryService {

    List<CategoryDto> getCategories();

    CategoryDto getCategory(Long id);

    void save(CategoryDto categoryDto);

    void update(CategoryDto categoryDto, Long id);

    void delete(Long id);
}
