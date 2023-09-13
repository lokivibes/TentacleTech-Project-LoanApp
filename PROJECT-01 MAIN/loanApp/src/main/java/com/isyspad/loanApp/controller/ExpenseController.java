package com.isyspad.loanApp.controller;

import com.isyspad.loanApp.model.ExpenseRequest;
import com.isyspad.loanApp.model.ExpenseResponse;
import com.isyspad.loanApp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping(path = "/expensecreate")
    public ResponseEntity<ExpenseResponse> tableCreation(@RequestBody ExpenseRequest values){
        ExpenseResponse response = expenseService.createexpense(values);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/expensefind")
    public ResponseEntity <List<ExpenseResponse>> getfind(@RequestParam(required = false)String userId, Float expenseAmount){
        List<ExpenseResponse> responses= expenseService.findvalue(userId,expenseAmount);
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }

    @PutMapping("expenseupdate")
    public ResponseEntity<ExpenseResponse>tableupdate(@RequestBody ExpenseRequest expenseRequest){
        ExpenseResponse expenseResponse=expenseService.updateExpense(expenseRequest);
        return new ResponseEntity<>(expenseResponse,HttpStatus.CREATED);
    }

}
