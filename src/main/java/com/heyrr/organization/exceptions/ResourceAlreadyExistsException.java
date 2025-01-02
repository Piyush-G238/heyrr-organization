package com.heyrr.organization.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public <T> ResourceAlreadyExistsException(String resource, String field, T value) {
        super(String.format("%s already exists for %s: '%s'", resource, field, value));
    }
}
