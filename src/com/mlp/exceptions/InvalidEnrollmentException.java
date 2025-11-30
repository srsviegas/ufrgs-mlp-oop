package com.mlp.exceptions;

public class InvalidEnrollmentException extends Exception {

    public InvalidEnrollmentException() {
        super();
    }

    public InvalidEnrollmentException(String message) {
        super(message);
    }

    public InvalidEnrollmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEnrollmentException(Throwable cause) {
        super(cause);
    }
}