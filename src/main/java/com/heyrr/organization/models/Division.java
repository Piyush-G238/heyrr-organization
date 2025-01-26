package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "division_tbl")
@Getter
@Setter
public class Division extends BaseEntity{

    @Id
    @Column(name = "division_pk")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "division_seq")
    @SequenceGenerator(name = "division_seq", allocationSize = 1, initialValue = 1001)
    private Long divisionPk;

    @Column(name = "division_name", length = 50, nullable = false)
    private String divisionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pk")
    private Company company;
}
