package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "department_tbl")
@Getter
@Setter
public class Department extends BaseEntity{

    @Id
    @Column(name = "department_pk")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID departmentPk;

    @Column(name = "department_name", nullable = false, unique = true)
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pk")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_pk")
    private Division division;
}
