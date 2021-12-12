package com.blogsite.blog.repository;

import com.blogsite.blog.domain.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @author hkaynar on 12.12.2021
 */
@Transactional
public interface ModelDao extends JpaRepository<ItemModel, Long> {
}
