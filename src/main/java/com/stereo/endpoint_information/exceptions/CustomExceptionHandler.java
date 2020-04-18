package com.stereo.endpoint_information.exceptions;

import com.stereo.endpoint_information.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@EnableWebMvc
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

     @ExceptionHandler(BadRequestException.class)
     public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request){
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorResponse error = new ErrorResponse("Bad Request", details);
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

}

    @ExceptionHandler(RecordAlreadyPresentException.class)
    public final ResponseEntity<Object> handleRecordAlreadyPresentException(RecordAlreadyPresentException ex, WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record already exists", details);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record does not exist", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

}
