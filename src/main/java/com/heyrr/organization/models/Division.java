package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Entity
@Table(name = "division_tbl")
@Getter
@Setter
public class Division extends BaseEntity{

    @Id
    @Column(name = "division_pk")
    private String divisionPk;

    @Column(name = "division_id", length = 12, nullable = false, updatable = false)
    private String divisionId;

    @Column(name = "division_name", length = 50, nullable = false)
    private String divisionName;

    @ManyToOne
    @JoinColumn(name = "business_unit_pk")
    private BusinessUnit businessUnit;

    @PrePersist
    private void setPrimaryKey() {
        if(!StringUtils.hasText(divisionId)) {
            divisionId = UUID.randomUUID().toString();
        }
    }
}
