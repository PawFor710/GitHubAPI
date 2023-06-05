package com.pawfor.github.exception;

import org.apache.coyote.Response;
import org.springframework.http.*;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Status", String.valueOf(HttpStatus.NOT_FOUND));
        errors.put("Message", "User with given login does not exist");
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
                                                                      HttpHeaders headers,
                                                                      HttpStatusCode status,
                                                                      WebRequest request) {
        if(request.getHeader("Accept").equals("application/xml")) {
            return new ResponseEntity<>("{ \n \"Status\": 406 NOT_ACCETABLE,\n \"message\": \"Format unsupported\"\n }",
                    HttpStatus.NOT_ACCEPTABLE);
        }
        return super.handleHttpMediaTypeNotAcceptable(ex, headers, status, request);
    }
}
