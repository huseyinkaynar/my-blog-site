package com.blogsite.blog.repository;

import com.blogsite.blog.domain.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hkaynar on 11.12.2021
 */
@Repository
public interface CategoryDao extends JpaRepository<CategoryModel, Long> {
    CategoryModel getCategoryModelById(Long id);
}
