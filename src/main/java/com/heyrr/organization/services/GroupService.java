package com.heyrr.organization.services;

import com.heyrr.organization.models.Group;
import com.heyrr.organization.payloads.GroupPayload;

public interface GroupService {

    String createGroup(GroupPayload groupPayload);

    Group findByGroupPk(String groupPk);
}
