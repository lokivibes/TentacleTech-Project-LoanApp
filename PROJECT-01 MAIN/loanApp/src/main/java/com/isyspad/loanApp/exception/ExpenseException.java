package com.isyspad.loanApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExpenseException {

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<String> exception(NumberFormatException e){
        return new ResponseEntity<>("Bill Number Already Exist", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler (value = {NullPointerException.class})
    public ResponseEntity<String>exception2(NullPointerException e){
        return new ResponseEntity<>("YOU ENTERED NULL VALUE PLEASE CHECK AGAIN", HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<String>exception1(NoSuchElementException e){
        return new ResponseEntity<>("No matching records found",HttpStatus.BAD_REQUEST);
    }
}
