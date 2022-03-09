package com.blogsite.blog.service.interceptor.registry;

import com.blogsite.blog.domain.model.ItemModel;
import com.blogsite.blog.service.interceptor.AfterRemoveInterceptor;
import com.blogsite.blog.service.interceptor.AfterSaveInterceptor;
import com.blogsite.blog.service.interceptor.BeforeRemoveInterceptor;
import com.blogsite.blog.service.interceptor.BeforeSaveInterceptor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hkaynar on 12.12.2021
 */
@Component
@Getter
@AllArgsConstructor
public class InterceptorRegistry {

    private final ApplicationContext context;

    public Map<BeforeSaveInterceptor, Class<? extends ItemModel>> beforeSaveInterceptor;
    public Map<BeforeRemoveInterceptor, Class<? extends ItemModel>> beforeRemoveInterceptor;
    public Map<AfterSaveInterceptor, Class<? extends ItemModel>> afterSaveInterceptor;
    public Map<AfterRemoveInterceptor, Class<? extends ItemModel>> afterRemoveInterceptor;
}
