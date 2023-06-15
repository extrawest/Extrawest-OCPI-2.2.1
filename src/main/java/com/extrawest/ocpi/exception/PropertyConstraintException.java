package com.extrawest.ocpi.exception;

public class PropertyConstraintException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_TEMPLATE =
            "Validation failed: [%s]. Current Value: [%s]";

    public PropertyConstraintException(Object currentFieldValue, String errorMessage) {
        super(createValidationMessage(currentFieldValue, errorMessage));
    }

    private static String createValidationMessage(Object fieldValue, String errorMessage) {
        return String.format(EXCEPTION_MESSAGE_TEMPLATE, errorMessage, fieldValue);
    }
}
