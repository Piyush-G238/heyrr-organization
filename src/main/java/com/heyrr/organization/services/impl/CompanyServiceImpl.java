package com.heyrr.organization.services.impl;

import com.heyrr.organization.exceptions.ResourceAlreadyExistsException;
import com.heyrr.organization.mappers.CompanyMapper;
import com.heyrr.organization.models.Company;
import com.heyrr.organization.models.Group;
import com.heyrr.organization.payloads.CompanyPayload;
import com.heyrr.organization.repositories.CompanyRepository;
import com.heyrr.organization.services.CompanyService;
import com.heyrr.organization.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final GroupService groupService;

    private final CompanyMapper companyMapper;

    @Override
    public String createCompany(CompanyPayload companyPayload, MultipartFile multipartFile) {
        boolean existsByCompanyId = companyRepository.existsByCompanyId(companyPayload.getCompanyId());
        if (existsByCompanyId)
            throw new ResourceAlreadyExistsException("Company", "companyId", companyPayload.getCompanyId());

        Group group = groupService.findByGroupPk(companyPayload.getGroupPk());
        Company company = companyMapper.createCompany(companyPayload);
        company.setGroup(group);

        companyRepository.save(company);
        return company.getCompanyPk();
    }
}
