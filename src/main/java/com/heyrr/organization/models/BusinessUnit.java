package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Entity
@Table(name = "business_unit_tbl")
@Getter @Setter
public class BusinessUnit extends BaseEntity {

    @Id
    @Column(name = "business_unit_pk")
    private String businessUnitPk;

    @Column(name = "business_unit_id", updatable = false, nullable = false, length = 12)
    private String businessUnitId;

    @Column(name = "business_unit_name", nullable = false, length = 100)
    private String businessUnitName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pk")
    private Company company;

    @Column(name = "bu_pf_number", length = 20)
    private String pfNumber;

    @Column(name = "bu_esi_number", length = 20)
    private String esiNumber;

    @Column(name = "bu_pan_gir_number", length = 20)
    private String panNumber;

    @Column(name = "bu_tan_number", length = 20)
    private String tanNumber;

    @Column(name = "bu_tds_circle", length = 20)
    private String tdsCircle;

    @Column(name = "bu_export_registration_number", length = 20)
    private String exportRegistrationNumber;

    @Column(name = "bu_registered_office")
    private boolean registeredOffice;

    @Column(name = "bu_factory_license_number", length = 50)
    private String factoryLicenseNumber;

    @Column(name = "bu_print_description", length = 256)
    private String printDescription;

    @PrePersist
    private void setPrimaryKey() {
        if(!StringUtils.hasText(businessUnitPk)) {
            businessUnitPk = UUID.randomUUID().toString();
        }
    }
}
