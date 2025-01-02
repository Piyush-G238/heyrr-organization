package com.heyrr.organization.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessUnitPayload {

    private String businessUnitId;

    private String businessUnitName;

    private String companyPk;

    private String pfNumber;

    private String esiNumber;

    private String panNumber;

    private String tanNumber;

    private String tdsCircle;

    private String exportRegistrationNumber;

    private boolean registeredOffice;

    private String factoryLicenseNumber;

    private String printDescription;
}
