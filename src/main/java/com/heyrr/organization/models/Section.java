package com.heyrr.organization.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "section_tbl")
public class Section extends BaseEntity {

    @Id
    @Column(name = "section_pk")
    private String sectionPk;

    @Column(name = "section_id", length = 12, updatable = false, nullable = false)
    private String sectionId;

    @Column(name = "section_name", length = 50, nullable = false)
    private String sectionName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "section_department_tbl",
            joinColumns = @JoinColumn(name = "section_pk"),
            inverseJoinColumns = @JoinColumn(name = "department_pk"))
    private List<Department> departments;
}
