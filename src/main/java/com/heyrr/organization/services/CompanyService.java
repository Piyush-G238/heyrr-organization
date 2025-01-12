package com.heyrr.organization.services;

import com.heyrr.organization.payloads.CompanyPayload;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface CompanyService {

    UUID createCompany(CompanyPayload companyPayload, MultipartFile multipartFile);
}
