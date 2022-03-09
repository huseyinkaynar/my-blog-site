package com.blogsite.blog.service.interceptor;

import com.blogsite.blog.domain.model.ItemModel;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hkaynar on 12.12.2021
 */
public interface Interceptor<T extends ItemModel> {
    default boolean isModified(T model, String attribute) {
        return model.getModifiedAttributes().stream().anyMatch(p -> StringUtils.equals(p, attribute));
    }
}
