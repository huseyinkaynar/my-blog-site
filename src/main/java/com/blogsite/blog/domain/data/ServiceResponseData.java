package com.blogsite.blog.domain.data;

import com.blogsite.blog.domain.enums.ProcessStatus;
import lombok.Data;

/**
 * @author hkaynar on 12.12.2021
 */
@Data
public class ServiceResponseData {
    private ProcessStatus status;
    private String errorMessage;
    private String errorMessageDetail;
    private Object data;
}
