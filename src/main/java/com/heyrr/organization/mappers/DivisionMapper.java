package com.heyrr.organization.mappers;

import com.heyrr.organization.models.Company;
import com.heyrr.organization.models.Division;
import com.heyrr.organization.payloads.DivisionPayload;

public class DivisionMapper {

    public Division createDivision(DivisionPayload divisionPayload) {
        Division division = new Division();
        division.setDivisionName(divisionPayload.getDivisionName());
        division.setRemarks(divisionPayload.getRemarks());

        Long companyPk = divisionPayload.getCompanyPk();
        Company company = new Company();
        company.setCompanyPk(companyPk);

        division.setCompany(company);
        return division;
    }
}
