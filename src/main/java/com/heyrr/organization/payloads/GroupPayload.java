package com.heyrr.organization.payloads;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GroupPayload extends BasePayload {

    @NotBlank(message = "groupName cannot be blank")
    private String groupName;
}
