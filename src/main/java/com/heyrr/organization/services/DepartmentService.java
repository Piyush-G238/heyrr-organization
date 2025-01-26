package com.heyrr.organization.services;

import com.heyrr.organization.payloads.DepartmentPayload;

public interface DepartmentService {

    Long createDepartment(DepartmentPayload departmentPayload);
}
