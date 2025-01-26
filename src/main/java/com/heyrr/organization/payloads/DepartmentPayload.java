package com.heyrr.organization.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentPayload extends BasePayload {

    @NotBlank(message = "departmentName is required")
    private String departmentName;

    @NotNull(message = "divisionPk is required")
    private Long divisionPk;

    @NotNull(message = "companyPk is required")
    private Long companyPk;
}
