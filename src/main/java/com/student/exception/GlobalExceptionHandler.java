package com.student.exception;

import com.student.Payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> ResourceNotFound(
            ResourceNotFoundException ex,
            WebRequest webRequest
    ){
        ErrorDetails er= new ErrorDetails(new Date(),
                ex.getMessage(),webRequest.getDescription(false)
                );

        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);

    }

}
