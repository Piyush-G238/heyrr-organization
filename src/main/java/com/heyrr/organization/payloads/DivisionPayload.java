package com.heyrr.organization.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DivisionPayload extends BasePayload {

    @NotBlank(message = "divisionName is required")
    private String divisionName;

    @NotNull(message = "companyPk is required")
    private Long companyPk;
}
