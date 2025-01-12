package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "division_tbl")
@Getter
@Setter
public class Division extends BaseEntity{

    @Id
    @Column(name = "division_pk")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID divisionPk;

    @Column(name = "division_name", length = 50, nullable = false, unique = true)
    private String divisionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pk")
    private Company company;
}
