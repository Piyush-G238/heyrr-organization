package com.heyrr.organization.repositories;

import com.heyrr.organization.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("""
            select (count(d) > 0) from Department d
            where upper(d.departmentName) = upper(?1) and d.division.divisionPk = ?2""")
    boolean existsByNameAndDivisionPk(String departmentName, Long divisionPk);
}
