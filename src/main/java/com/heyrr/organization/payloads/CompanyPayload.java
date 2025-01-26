package com.heyrr.organization.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyPayload extends BasePayload {

    @NotBlank(message = "companyId cannot be blank")
    private String companyCode;

    @NotBlank(message = "companyName cannot be blank")
    @Size(max = 50, message = "companyName cannot exceed more than 12 characters")
    private String companyName;

    private String companyLogoUrl;

    @NotBlank(message = "email cannot be blank")
    private String email;

    @NotBlank(message = "url cannot be blank")
    private String url;

    @NotNull(message = "group cannot be null")
    private Long groupPk;

    private boolean isParent = true;

    private Long parentCompanyPk;
}
