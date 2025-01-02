package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_type_tbl")
@Getter
@Setter
public class EmployeeType extends BaseEntity{

    @Id
    @Column(name = "employee_type_pk")
    private String employeeTypePk;

    @Column(name = "employee_type_id", length = 12, updatable = false, nullable = false)
    private String employeeTypeId;

    @Column(name = "employee_type_name", length = 50, nullable = false)
    private String employeeTypeName;

    @ManyToOne
    @JoinColumn(name = "business_unit_pk")
    private BusinessUnit businessUnit;
}
