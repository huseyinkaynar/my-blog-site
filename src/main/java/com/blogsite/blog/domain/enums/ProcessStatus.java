package com.blogsite.blog.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hkaynar on 12.12.2021
 */
@AllArgsConstructor
@Getter
public enum ProcessStatus {
    SUCCESS("SUCCESS"), ERROR("ERROR");

    private String value;
}
