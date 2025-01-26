package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department_tbl")
@Getter
@Setter
public class Department extends BaseEntity{

    @Id
    @Column(name = "department_pk")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    @SequenceGenerator(name = "department_seq", allocationSize = 1, initialValue = 1001)
    private Long departmentPk;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pk")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_pk")
    private Division division;
}
