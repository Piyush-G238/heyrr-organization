package com.heyrr.organization.controllers;

import com.heyrr.organization.constants.StringConstant;
import com.heyrr.organization.payloads.DepartmentPayload;
import com.heyrr.organization.payloads.GenericPayload;
import com.heyrr.organization.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping(produces = "application/json")
    GenericPayload<Long> createDepartment(@Valid @RequestBody DepartmentPayload departmentPayload) {
        Long newDepartmentPk = departmentService.createDepartment(departmentPayload);
        return new GenericPayload<>(StringConstant.DEPARTMENT_CREATED, newDepartmentPk, 0);
    }
}
