package com.heyrr.organization.services.impl;

import com.heyrr.organization.exceptions.ResourceAlreadyExistsException;
import com.heyrr.organization.exceptions.ResourceNotFoundException;
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

    private final GroupMapper groupMapper;

    @Override
    public String createGroup(GroupPayload groupPayload) {
        boolean existsById = groupRepository.existsByGroupId(groupPayload.getGroupId());
        if (existsById)
            throw new ResourceAlreadyExistsException("Group", "groupId", groupPayload.getGroupId());
        Group group = groupMapper.createGroup(groupPayload);
        groupRepository.save(group);

        return group.getGroupPk();
    }

    @Override
    public Group findByGroupPk(String groupPk) {
        return groupRepository
                .findById(groupPk)
                .orElseThrow(() -> new ResourceNotFoundException("Group", "groupPk", groupPk));
    }
}
