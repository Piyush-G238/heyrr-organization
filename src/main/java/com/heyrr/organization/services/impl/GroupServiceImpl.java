package com.heyrr.organization.services.impl;

import com.heyrr.organization.exceptions.ResourceAlreadyExistsException;
import com.heyrr.organization.mappers.GroupMapper;
import com.heyrr.organization.models.Group;
import com.heyrr.organization.payloads.GroupPayload;
import com.heyrr.organization.repositories.GroupRepository;
import com.heyrr.organization.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper = new GroupMapper();

    @Override
    public Long createGroup(GroupPayload groupPayload) {
        String groupName = groupPayload.getGroupName();
        boolean existsByName = groupRepository.existsByGroupName(groupName);
        if (existsByName)
            throw new ResourceAlreadyExistsException("Group", "groupName", groupName);
        Group group = groupMapper.createGroup(groupPayload);
        groupRepository.save(group);

        return group.getGroupPk();
    }
}
