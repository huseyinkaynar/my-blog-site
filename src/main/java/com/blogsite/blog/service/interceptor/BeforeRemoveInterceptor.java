package com.blogsite.blog.service.interceptor;

import com.blogsite.blog.service.exception.inteceptor.InterceptorException;

public interface BeforeRemoveInterceptor<MODEL>  {

    /*
        this method is invoked before remove item model
     */

    void beforeRemove(MODEL model) throws InterceptorException;
}
