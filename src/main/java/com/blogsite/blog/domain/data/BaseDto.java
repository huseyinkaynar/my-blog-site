package com.blogsite.blog.domain.data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hkaynar on 11.12.2021
 */
public class BaseDto implements Serializable {
    private Long id;
    private String isoCode;
    private String createdBy;
    private String lastModifiedBy;
    private Date createdDate;
    private Date lastModifiedDate;
}
