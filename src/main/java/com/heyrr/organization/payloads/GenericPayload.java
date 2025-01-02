package com.heyrr.organization.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenericPayload <T> {

    private String message;

    private T data;

    private long totalCount;

}
