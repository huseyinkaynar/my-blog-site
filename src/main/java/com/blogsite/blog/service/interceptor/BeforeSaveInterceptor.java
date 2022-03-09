package com.blogsite.blog.service.interceptor;

import com.blogsite.blog.service.exception.inteceptor.InterceptorException;

public interface BeforeSaveInterceptor<MODEL> {

    /*
        this method is invoked before save item model
     */
    void beforeSave(MODEL model) throws InterceptorException;
}
