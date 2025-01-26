package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "group_tbl")
@Getter
@Setter
public class Group extends BaseEntity {

    @Id
    @Column(name = "group_pk")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_sq")
    @SequenceGenerator(name = "group_sq", initialValue = 1001, allocationSize = 1)
    private Long groupPk;

    @Column(name = "group_name", nullable = false, unique = true)
    private String groupName;
}
