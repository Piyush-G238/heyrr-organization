package com.heyrr.organization.services;

import com.heyrr.organization.payloads.GroupPayload;

import java.util.UUID;

public interface GroupService {

    UUID createGroup(GroupPayload groupPayload);

    boolean findByGroupPk(UUID groupPk);
}
