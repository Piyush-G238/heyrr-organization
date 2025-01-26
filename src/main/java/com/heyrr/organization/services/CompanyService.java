package com.heyrr.organization.services;

import com.heyrr.organization.payloads.CompanyPayload;
import org.springframework.web.multipart.MultipartFile;

public interface CompanyService {

    Long createCompany(CompanyPayload companyPayload, MultipartFile multipartFile);
}
