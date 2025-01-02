package com.heyrr.organization.handlers;

import com.heyrr.organization.exceptions.ResourceAlreadyExistsException;
import com.heyrr.organization.exceptions.ResourceNotFoundException;
import com.heyrr.organization.payloads.ErrorPayload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorPayload resourceNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest request) {
        ErrorPayload payload = new ErrorPayload();
        payload.setApiPath(request.getDescription(false));
        payload.setErrorMessage(ex.getMessage());
        return payload;
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorPayload resourceAlreadyExistsExceptionHandler(ResourceAlreadyExistsException ex, WebRequest request) {
        ErrorPayload payload = new ErrorPayload();
        payload.setApiPath(request.getDescription(false));
        payload.setErrorMessage(ex.getMessage());
        return payload;
    }
}
