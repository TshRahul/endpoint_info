package com.stereo.endpoint_information.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RecordAlreadyPresentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecordAlreadyPresentException(String message){
        super(message);
    }
}
