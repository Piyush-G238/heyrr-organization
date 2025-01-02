package com.heyrr.organization.models;

import com.heyrr.organization.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Column(name = "created_on", updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime createdOn;

    @Column(name = "updated_on", insertable = false)
    @LastModifiedDate
    private LocalDateTime updatedOn;

    @Column(name = "created_by", updatable = false, nullable = false)
    private String createdBy = "Anonymous";

    @Column(name = "updated_by", insertable = false)
    private String updatedBy = "Anonymous";

    @Column(name = "remarks", length = 256)
    private String remarks;

    @Column(name = "status", nullable = false)
    private String status = Status.ACTIVE.name();
}
