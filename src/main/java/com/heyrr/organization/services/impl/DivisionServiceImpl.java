package com.heyrr.organization.services.impl;

import com.heyrr.organization.exceptions.ResourceAlreadyExistsException;
import com.heyrr.organization.exceptions.ResourceNotFoundException;
import com.heyrr.organization.mappers.DivisionMapper;
import com.heyrr.organization.models.Division;
import com.heyrr.organization.payloads.DivisionPayload;
import com.heyrr.organization.repositories.CompanyRepository;
import com.heyrr.organization.repositories.DivisionRepository;
import com.heyrr.organization.services.DivisionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;

    private final CompanyRepository companyRepository;

    private final DivisionMapper divisionMapper = new DivisionMapper();

    @Override
    public Long createDivision(DivisionPayload divisionPayload) {
        String divisionName = divisionPayload.getDivisionName();

        Long companyPk = divisionPayload.getCompanyPk();
        boolean companyExists = companyRepository.existsById(companyPk);
        if (!companyExists)
            throw new ResourceNotFoundException("Company", "companyPk", companyPk);

        boolean exists = divisionRepository.existsByNameAndCompany(companyPk, divisionName);
        if (exists)
            throw new ResourceAlreadyExistsException("Division", "divisionName", divisionName);

        Division division = divisionMapper.createDivision(divisionPayload);
        divisionRepository.save(division);
        return division.getDivisionPk();
    }
}
