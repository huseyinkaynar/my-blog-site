package com.blogsite.blog.service;

import com.blogsite.blog.domain.model.ItemModel;

/**
 * @author hkaynar on 12.12.2021
 */
public interface ModelService {
    <T extends ItemModel> T save(T t);

    <T extends ItemModel> Iterable<T> saveAll(Iterable<T> var1);

    <T extends ItemModel> Iterable<T> saveAll(T... t);

    <T extends ItemModel> void remove(T t);

    <T extends ItemModel>  void  removeAll(Iterable<T> var1);

    <T extends ItemModel> T create(Class<T> code);

    <T extends ItemModel> T refresh(T t);
}
