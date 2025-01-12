package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "group_tbl")
@Getter
@Setter
public class Group extends BaseEntity {

    @Id
    @Column(name = "group_pk")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID groupPk;

    @Column(name = "group_name", nullable = false, unique = true)
    private String groupName;
}
