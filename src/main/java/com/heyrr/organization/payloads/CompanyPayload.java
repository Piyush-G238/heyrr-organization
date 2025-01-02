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
    @Size(max = 12, message = "companyId cannot exceed more than 12 characters")
    private String companyId;

    @NotBlank(message = "companyName cannot be blank")
    @Size(max = 50, message = "companyName cannot exceed more than 12 characters")
    private String companyName;

    private String companyLogoUrl;

    @NotBlank(message = "email cannot be blank")
    @Size(max = 50, message = "email cannot exceed more than 50 characters")
    private String email;

    @NotBlank(message = "url cannot be blank")
    @Size(max = 50, message = "url cannot exceed more than 50 characters")
    private String url;

    @NotNull(message = "group cannot be null")
    private String groupPk;

    private boolean isParent = true;

    private String parentCompanyPk;
}
