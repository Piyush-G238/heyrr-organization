package com.heyrr.organization.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GroupPayload extends BasePayload {

    @NotBlank(message = "groupId cannot be blank")
    @Size(max = 12, message = "groupId cannot exceed more than 12 characters")
    private String groupId;

    @NotBlank(message = "groupName cannot be blank")
    @Size(max = 50, message = "groupName cannot exceed more than 50 characters")
    private String groupName;
}
