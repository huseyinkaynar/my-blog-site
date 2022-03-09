package com.blogsite.blog.service.interceptor;

import com.blogsite.blog.service.exception.inteceptor.InterceptorException;

public interface AfterRemoveInterceptor<MODEL> extends Interceptor {

    /*
        this method is invoked after remove item model
     */

    void afterRemove(MODEL model) throws InterceptorException;
}
