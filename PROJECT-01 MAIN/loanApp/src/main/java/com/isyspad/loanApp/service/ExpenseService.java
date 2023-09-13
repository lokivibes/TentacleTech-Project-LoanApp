package com.isyspad.loanApp.service;

import com.isyspad.loanApp.model.ExpenseRequest;
import com.isyspad.loanApp.model.ExpenseResponse;

import java.util.List;

public interface ExpenseService {

    ExpenseResponse createexpense(ExpenseRequest input);

    List<ExpenseResponse> findvalue(String userId, Float expenseAmount);

    ExpenseResponse updateExpense( ExpenseRequest update);
}
