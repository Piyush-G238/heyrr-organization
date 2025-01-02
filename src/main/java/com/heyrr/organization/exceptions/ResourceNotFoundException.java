package com.heyrr.organization.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public <T> ResourceNotFoundException(String resource, String field, T value) {
        super(String.format("%s not found for %s: '%s'", resource, field, value));
    }
}
