package com.blogsite.blog.repository;

import com.blogsite.blog.domain.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hkaynar on 11.12.2021
 */
@Repository
@Transactional
public interface PostDao extends JpaRepository<PostModel, Long> {
    PostModel getPostModelById(Long id);
}
