package com.heyrr.organization.controllers;

import com.heyrr.organization.payloads.BusinessUnitPayload;
import com.heyrr.organization.payloads.GenericPayload;
import com.heyrr.organization.services.BusinessUnitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/business-units")
@AllArgsConstructor
public class BusinessUnitController {

    // private final BusinessUnitService businessUnitService;

    @PostMapping(produces = "application/json")
    GenericPayload<String> createBusinessUnit(@RequestBody BusinessUnitPayload businessUnitPayload) {

        return null;
    }
}
