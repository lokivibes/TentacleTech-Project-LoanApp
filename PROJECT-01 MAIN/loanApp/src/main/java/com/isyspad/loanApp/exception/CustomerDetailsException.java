package com.isyspad.loanApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.InputMismatchException;

@RestControllerAdvice
public class CustomerDetailsException {
    @ExceptionHandler
    public ResponseEntity<String> error (NullPointerException e){
        return new ResponseEntity<String>("values cannot be null", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<String> error (InputMismatchException r){
        return new ResponseEntity<String>("Invalid input entered", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> error (IllegalArgumentException r){
        return new ResponseEntity<String>("Invalid Argument or mobile Number", HttpStatus.BAD_REQUEST);
    }

}
