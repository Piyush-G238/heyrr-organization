package com.heyrr.organization.payloads;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ErrorPayload {

    private String apiPath;

    private LocalDateTime timestamp = LocalDateTime.now();

    private String errorMessage;

    private Map<String, String> fieldErrors;
}
