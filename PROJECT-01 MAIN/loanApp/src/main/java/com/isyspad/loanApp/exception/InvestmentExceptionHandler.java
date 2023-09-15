package com.isyspad.loanApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvestmentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> nullPointer(NullPointerException e){
        return new ResponseEntity<>("Null Prohibited!", HttpStatus.BAD_REQUEST);
    }
}
