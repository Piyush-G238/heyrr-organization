package com.heyrr.organization.mappers;

import com.heyrr.organization.models.Company;
import com.heyrr.organization.payloads.CompanyPayload;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company createCompany(CompanyPayload companyPayload) {
        Company company = new Company();
        company.setCompanyCode(companyPayload.getCompanyCode());
        company.setCompanyName(companyPayload.getCompanyName());
        company.setRemarks(companyPayload.getRemarks());
        company.setCompanyLogoUrl(companyPayload.getCompanyLogoUrl());
        company.setEmail(companyPayload.getEmail());
        company.setUrl(companyPayload.getUrl());
        company.setParent(companyPayload.isParent());
        return company;
    }
}
