package com.itechart.boot.utils;

import org.springframework.validation.Errors;

/**
 * Thrown when incoming requestDTO validation fails.
 * Constraints and validation rules applied on DTO objects.
 * Contains all requestDTO fields that didn't meet the specified requirements.
 * Usually thrown from controller level.
 */
public class RequestDTOValidationException extends ApplicationException {

    private Errors errors;

    public Errors getErrors() {
        return errors;
    }

    public RequestDTOValidationException(String message) {
        super(message);
    }

    public RequestDTOValidationException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }
}
