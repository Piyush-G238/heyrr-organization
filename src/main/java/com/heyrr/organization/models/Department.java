package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Entity
@Table(name = "department_tbl")
@Getter
@Setter
public class Department extends BaseEntity{

    @Id
    @Column(name = "department_pk")
    private String departmentPk;

    @Column(name = "department_id", length = 12, nullable = false, updatable = false)
    private String departmentId;

    @Column(name = "department_name", length = 50, nullable = false)
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_unit_pk")
    private BusinessUnit businessUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_pk")
    private Division division;

    @PrePersist
    private void setPrimaryKey() {
        if(!StringUtils.hasText(departmentPk)) {
            departmentPk = UUID.randomUUID().toString();
        }
    }
}
