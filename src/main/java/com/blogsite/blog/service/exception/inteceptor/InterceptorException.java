package com.blogsite.blog.service.exception.inteceptor;

/**
 * @author hkaynar on 12.12.2021
 */
public class InterceptorException extends Exception {

    public InterceptorException(String message) {
        super(message);
    }

    public InterceptorException(Throwable cause) {
        super(cause);
    }

    public InterceptorException(String message, Throwable cause) {
        super(message, cause);
    }
}
