package com.blogsite.blog.service.interceptor;

import com.blogsite.blog.service.exception.inteceptor.InterceptorException;

public interface AfterSaveInterceptor<MODEL> extends Interceptor {

    /*
        this method is invoked after save item model
     */
    void afterSave(MODEL model) throws InterceptorException;
}
