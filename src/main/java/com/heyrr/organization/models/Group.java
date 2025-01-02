package com.heyrr.organization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Entity
@Table(name = "group_tbl")
@Getter
@Setter
public class Group extends BaseEntity {

    @Id
    @Column(name = "group_pk")
    private String groupPk;

    @Column(name = "group_id", updatable = false, length = 12, nullable = false)
    private String groupId;

    @Column(name = "group_name", length = 50, nullable = false)
    private String groupName;

    @PrePersist
    private void setPrimaryKey() {
        if(!StringUtils.hasText(groupPk)) {
            groupPk = UUID.randomUUID().toString();
        }
    }
}
