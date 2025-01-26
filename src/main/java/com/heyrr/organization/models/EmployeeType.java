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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_type_seq")
    @SequenceGenerator(name = "employee_type_seq", allocationSize = 1, initialValue = 1001)
    private Long employeeTypePk;

    @Column(name = "employee_type_name", nullable = false)
    private String employeeTypeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pk")
    private Company company;
}
