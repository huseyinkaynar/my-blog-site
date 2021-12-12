package com.blogsite.blog.repository;

import com.blogsite.blog.domain.model.PostMetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hkaynar on 11.12.2021
 */
@Repository
public interface PostMetaDao extends JpaRepository<PostMetaModel, Long> {
    PostMetaModel getPostMetaModelById(Long id);

}
