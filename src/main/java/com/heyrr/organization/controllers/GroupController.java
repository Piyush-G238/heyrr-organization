package com.heyrr.organization.controllers;

import com.heyrr.organization.constants.StringConstant;
import com.heyrr.organization.payloads.GenericPayload;
import com.heyrr.organization.payloads.GroupPayload;
import com.heyrr.organization.services.GroupService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/groups")
@AllArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    GenericPayload<String> createGroup(@Valid @RequestBody GroupPayload groupPayload) {
        UUID newGroupPk = groupService.createGroup(groupPayload);
        return new GenericPayload<>(StringConstant.GROUP_CREATED, newGroupPk.toString(), 0);
    }
}
