package com.heyrr.organization.services;

import com.heyrr.organization.payloads.GroupPayload;

public interface GroupService {

    Long createGroup(GroupPayload groupPayload);
}
