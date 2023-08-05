package com.isyspad.loanApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.InputMismatchException;

@RestControllerAdvice

public class DueCollectionException {
    @ExceptionHandler
    public ResponseEntity<String> error1 (NullPointerException e){
        return new ResponseEntity<String>("Your field cannot be null or empty", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<String> error2 (IllegalArgumentException r){
        return new ResponseEntity<String>("input cannot be empty", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String>error3(Exception e){
        return new ResponseEntity<String>("RunTime error"+e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String>error3(RuntimeException e){
        return new ResponseEntity<String>("Give correct date",HttpStatus.BAD_REQUEST);

}}
