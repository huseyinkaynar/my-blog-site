package com.blogsite.blog.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hkaynar on 09.12.2021
 */
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode
public class ItemModel implements Serializable {
    public static final String ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @Transient
    private Set<String> modifiedAttributes = new HashSet<>();

    protected void addChangeAttribute(String value) {
        modifiedAttributes.add(value);
    }
}
