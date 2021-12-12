package com.blogsite.blog.service.exception.model;

/**
 * @author hkaynar on 12.12.2021
 */
public class ModelNotFoundException extends RuntimeException {
    protected Object[] args;

    protected String messageKey;

    public ModelNotFoundException(String message, String messageKey, Object[] args) {
        super(message);
        this.messageKey = messageKey;
        this.args = args;
    }

    public ModelNotFoundException(String message) {
        super(message);
    }

    public ModelNotFoundException(Throwable cause) {
        super(cause);
    }

    public ModelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
