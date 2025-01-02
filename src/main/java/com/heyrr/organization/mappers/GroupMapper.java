package com.heyrr.organization.mappers;

import com.heyrr.organization.models.Group;
import com.heyrr.organization.payloads.GroupPayload;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {

    public Group createGroup(GroupPayload groupPayload) {
        Group group = new Group();
        group.setGroupId(groupPayload.getGroupId());
        group.setGroupName(groupPayload.getGroupName());
        group.setRemarks(group.getRemarks());
        return group;
    }
}
