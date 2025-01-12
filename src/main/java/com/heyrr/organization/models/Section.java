package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "section_tbl")
@Getter @Setter
public class Section extends BaseEntity {

    @Id
    @Column(name = "section_pk")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID sectionPk;

    @Column(name = "section_name", nullable = false, unique = true)
    private String sectionName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "section_department_tbl",
            joinColumns = @JoinColumn(name = "section_pk"),
            inverseJoinColumns = @JoinColumn(name = "department_pk"))
    private List<Department> departments;
}
