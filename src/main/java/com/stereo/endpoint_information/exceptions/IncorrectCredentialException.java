package com.stereo.endpoint_information.exceptions;

public class IncorrectCredentialException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IncorrectCredentialException(String message) {
        super(message);
    }
}
