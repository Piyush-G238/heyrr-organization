package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Entity
@Table(name = "company_tbl")
@Getter @Setter
public class Company extends BaseEntity {

    @Id
    @Column(name = "company_pk")
    private String companyPk;

    @Column(name = "company_id", length = 12, updatable = false, nullable = false)
    private String companyId;

    @Column(name = "company_name", length = 50, nullable = false)
    private String companyName;

    @Column(name = "company_logo_url", length = 256)
    private String companyLogoUrl;

    @Column(name = "company_email", nullable = false, length = 20)
    private String email;

    @Column(name = "company_url", nullable = false, length = 50)
    private String url;

    @Column(name = "company_is_parent")
    private boolean isParent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_company_pk", referencedColumnName = "company_pk")
    private Company parentCompanyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_pk")
    private Group group;

    @PrePersist
    private void setPrimaryKey() {
        if(!StringUtils.hasText(companyPk)) {
            companyPk = UUID.randomUUID().toString();
        }
    }

}
