package com.blogsite.blog.service.exception.model;

/**
 * @author hkaynar on 12.12.2021
 */
public class ModelSaveException extends RuntimeException {
    protected Object[] args;

    protected String messageKey;

    public ModelSaveException(String message, String messageKey, Object[] args) {
        super(message);
        this.messageKey = messageKey;
        this.args = args;
    }

    public ModelSaveException(String message) {
        super(message);
    }

    public ModelSaveException(Throwable cause) {
        super(cause);
    }

    public ModelSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
