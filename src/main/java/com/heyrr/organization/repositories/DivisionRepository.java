package com.heyrr.organization.repositories;

import com.heyrr.organization.models.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DivisionRepository extends JpaRepository<Division, Long> {

    @Query("select (count(d) > 0) from Division d where d.company.companyPk = ?1 and upper(d.divisionName) = upper(?2)")
    boolean existsByNameAndCompany(Long companyPk, String divisionName);
}
