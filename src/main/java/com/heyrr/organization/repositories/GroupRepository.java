package com.heyrr.organization.repositories;

import com.heyrr.organization.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, String> {

    @Query("select (count(g) > 0) from Group g where upper(g.groupId) = upper(?1)")
    boolean existsByGroupId(String groupId);

}
