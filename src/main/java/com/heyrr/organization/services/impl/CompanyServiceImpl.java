package com.heyrr.organization.services.impl;

import com.heyrr.organization.exceptions.ResourceAlreadyExistsException;
import com.heyrr.organization.exceptions.ResourceNotFoundException;
import com.heyrr.organization.mappers.CompanyMapper;
import com.heyrr.organization.models.Company;
import com.heyrr.organization.models.Group;
import com.heyrr.organization.payloads.CompanyPayload;
import com.heyrr.organization.repositories.CompanyRepository;
import com.heyrr.organization.repositories.GroupRepository;
import com.heyrr.organization.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final GroupRepository groupRepository;

    private final CompanyMapper companyMapper;

    @Override
    public Long createCompany(CompanyPayload companyPayload, MultipartFile multipartFile) {
        boolean existsByCompanyCode = companyRepository.existsByCompanyCode(companyPayload.getCompanyCode());
        if (existsByCompanyCode)
            throw new ResourceAlreadyExistsException("Company", "companyCode", companyPayload.getCompanyCode());

        Long groupPk = companyPayload.getGroupPk();
        boolean groupExists = groupRepository.existsById(groupPk);
        if (!groupExists)
            throw new ResourceNotFoundException("Group", "groupPk", companyPayload.getGroupPk());
        Company company = companyMapper.createCompany(companyPayload);
        Group group = new Group();
        group.setGroupPk(groupPk);
        company.setGroup(group);

        companyRepository.save(company);
        return company.getCompanyPk();
    }
}
