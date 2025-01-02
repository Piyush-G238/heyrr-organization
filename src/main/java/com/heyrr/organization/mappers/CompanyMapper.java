package com.heyrr.organization.mappers;

import com.heyrr.organization.models.Company;
import com.heyrr.organization.payloads.CompanyPayload;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company createCompany(CompanyPayload companyPayload) {
        Company company = new Company();
        company.setCompanyId(companyPayload.getCompanyId());
        company.setCompanyName(companyPayload.getCompanyName());
        company.setRemarks(companyPayload.getRemarks());
        company.setCompanyLogoUrl(companyPayload.getCompanyLogoUrl());
        company.setEmail(companyPayload.getEmail());
        company.setUrl(companyPayload.getUrl());
        return company;
    }
}
