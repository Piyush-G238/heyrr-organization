package com.heyrr.organization.services.impl;

import com.heyrr.organization.exceptions.ResourceAlreadyExistsException;
import com.heyrr.organization.exceptions.ResourceNotFoundException;
import com.heyrr.organization.payloads.DepartmentPayload;
import com.heyrr.organization.repositories.DepartmentRepository;
import com.heyrr.organization.repositories.DivisionRepository;
import com.heyrr.organization.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DivisionRepository divisionRepository;

    @Override
    public Long createDepartment(DepartmentPayload departmentPayload) {
        String departmentName = departmentPayload.getDepartmentName();

        Long divisionPk =departmentPayload.getDivisionPk();

        boolean divisionExists = divisionRepository.existsById(divisionPk);
        if (!divisionExists)
            throw new ResourceNotFoundException("Division", "divisionPk", divisionPk);

        boolean exists = departmentRepository.existsByNameAndDivisionPk(departmentName, divisionPk);
        if (exists)
            throw new ResourceAlreadyExistsException("Department", "DepartmentName", departmentName);

        return null;
    }
}
