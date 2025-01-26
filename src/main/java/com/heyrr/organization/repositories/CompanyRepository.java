package com.heyrr.organization.repositories;

import com.heyrr.organization.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select (count(c) > 0) from Company c where upper(c.companyCode) = upper(?1)")
    boolean existsByCompanyCode(String companyCode);
}
