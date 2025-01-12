package com.heyrr.organization.repositories;

import com.heyrr.organization.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {

    @Query("select (count(g) > 0) from Group g where upper(g.groupName) = upper(?1)")
    boolean existsByGroupName(String groupId);

}
