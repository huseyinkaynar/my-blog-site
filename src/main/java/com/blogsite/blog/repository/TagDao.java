package com.blogsite.blog.repository;

import com.blogsite.blog.domain.model.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hkaynar on 11.12.2021
 */
@Repository
@Transactional
public interface TagDao extends JpaRepository<TagModel, Long> {
    TagModel getTagModelById(Long id);
}
