package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "section_tbl")
@Getter @Setter
public class Section extends BaseEntity {

    @Id
    @Column(name = "section_pk")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "section_seq")
    @SequenceGenerator(name = "section_seq", allocationSize = 1, initialValue = 1001)
    private Long sectionPk;

    @Column(name = "section_name", nullable = false)
    private String sectionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pk")
    private Company company;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "section_department_tbl",
            joinColumns = @JoinColumn(name = "section_pk"),
            inverseJoinColumns = @JoinColumn(name = "department_pk"))
    private List<Department> departments;
}
