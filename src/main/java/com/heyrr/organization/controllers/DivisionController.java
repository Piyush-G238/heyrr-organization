package com.heyrr.organization.controllers;

import com.heyrr.organization.constants.StringConstant;
import com.heyrr.organization.payloads.DivisionPayload;
import com.heyrr.organization.payloads.GenericPayload;
import com.heyrr.organization.services.DivisionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/divisions")
@AllArgsConstructor
public class DivisionController {

    private final DivisionService divisionService;

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    GenericPayload<Long> createDivision(@Valid @RequestBody DivisionPayload payload) {
        Long newDivisionPk = divisionService.createDivision(payload);
        return new GenericPayload<>(StringConstant.DIVISION_CREATED, newDivisionPk, 0);
    }
}
