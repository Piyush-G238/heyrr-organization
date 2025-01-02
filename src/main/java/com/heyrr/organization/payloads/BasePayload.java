package com.heyrr.organization.payloads;

import com.heyrr.organization.enums.Status;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePayload {

    @Size(max = 256, message = "remarks cannot exceed more than 256 characters")
    private String remarks;

    private Status status;
}
