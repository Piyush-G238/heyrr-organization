package com.heyrr.organization.controllers;

import com.heyrr.organization.constants.StringConstant;
import com.heyrr.organization.payloads.CompanyPayload;
import com.heyrr.organization.payloads.GenericPayload;
import com.heyrr.organization.services.CompanyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/companies")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping(consumes = "multipart/form-data", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    GenericPayload<String> createCompany(
            @Valid @RequestPart(name = "payload") CompanyPayload companyPayload,
            @RequestPart(name = "attachment", required = false) MultipartFile multipartFile) {

        String newCompanyPk = companyService.createCompany(companyPayload, multipartFile);
        return new GenericPayload<>(StringConstant.COMPANY_CREATED, newCompanyPk, 0);
    }
}
