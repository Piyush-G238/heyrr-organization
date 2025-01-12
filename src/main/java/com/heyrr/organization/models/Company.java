package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "company_tbl")
@Getter @Setter
public class Company extends BaseEntity {

    @Id
    @Column(name = "company_pk")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID companyPk;

    @Column(name = "company_code", unique = true, nullable = false, length = 50)
    private String companyCode;

    @Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    @Column(name = "company_logo_url", length = 256)
    private String companyLogoUrl;

    @Column(name = "company_email", nullable = false)
    private String email;

    @Column(name = "company_url", nullable = false)
    private String url;

    @Column(name = "company_is_parent")
    private boolean isParent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_company_pk", referencedColumnName = "company_pk")
    private Company parentCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_pk", referencedColumnName = "group_pk")
    private Group group;

}
