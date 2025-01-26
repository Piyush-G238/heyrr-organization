package com.heyrr.organization.repositories;

import com.heyrr.organization.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("select (count(g) > 0) from Group g where upper(g.groupName) = upper(?1)")
    boolean existsByGroupName(String groupName);

}
