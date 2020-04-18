package com.stereo.endpoint_information.exceptions;

public class RecordNotFoundException extends RuntimeException{

    public  RecordNotFoundException(String message){
        super(message);
    }
}
