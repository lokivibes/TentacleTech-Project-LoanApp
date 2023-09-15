package com.isyspad.loanApp.service.impl;

import com.isyspad.loanApp.entity.Expense;
import com.isyspad.loanApp.model.ExpenseRequest;
import com.isyspad.loanApp.model.ExpenseResponse;
import com.isyspad.loanApp.repository.ExpenseRepository;
import com.isyspad.loanApp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseServiceImpl implements ExpenseService {


    @Autowired
    ExpenseRepository repository;
    public Expense setrequest(ExpenseRequest request) {
        Expense expense = new Expense();
        Expense lastSavedEntity = repository.findLastSavedEntity();
        Float currentExpenseAmount = request.getExpenseAmount();
        Float totalExpenseAmount = (lastSavedEntity != null) ? lastSavedEntity.getTotalExpenseAmount() : 0;
        totalExpenseAmount = totalExpenseAmount + currentExpenseAmount;
        Float newRemainingBalance = request.getTotalAmount() - totalExpenseAmount;


        expense.setBillNumber(request.getBillNumber());
        expense.setExpenseDate(request.getExpenseDate());
        expense.setTotalExpenseAmount(totalExpenseAmount);
        expense.setTotalAmount(request.getTotalAmount());
        expense.setId(request.getId());
        expense.setRemainingBalance(newRemainingBalance);
        expense.setExpenseDescription(request.getExpenseDescription());
        expense.setExpenseAmount(request.getExpenseAmount());
        expense.setUserId(request.getUserId());
        return expense;
    }

    public ExpenseResponse setResponse(Expense entity) {
        ExpenseResponse response = new ExpenseResponse();
        response.setId(entity.getId());
        response.setTotalExpenseAmount(entity.getTotalExpenseAmount());
        response.setRemainingBalance(entity.getRemainingBalance());
        response.setTotalAmount(entity.getTotalAmount());
        response.setExpenseAmonut(entity.getExpenseAmount());
        response.setExpenseDescription(entity.getExpenseDescription());
        response.setExpenseDate(entity.getExpenseDate());
        response.setUserId(entity.getUserId());
        response.setBillNumber(entity.getBillNumber());
        return response;
    }

    @Override
    public ExpenseResponse createexpense(ExpenseRequest input) {
        Expense expense;
        if (basicvalidation(input)) {

            expense = setrequest(input);
            expense = repository.save(expense);
            return setResponse(expense);

        } else {
            throw new NullPointerException();
        }
    }

    public boolean basicvalidation(ExpenseRequest expenseRequest) {
        if (expenseRequest.getUserId() != null && expenseRequest.getExpenseAmount() != null &&
                expenseRequest.getExpenseDescription() != null && expenseRequest.getBillNumber() != null) {
            int count = repository.countbillNumber(expenseRequest.getBillNumber());
            if (count == 0) {
                return true;
            } else {
                throw new NumberFormatException();
            }
        }
        return false;
    }

    @Override
    public List<ExpenseResponse> findvalue(String userId, Float expenseAmount,String billNumber) {

        List<Expense> list = new ArrayList<>();

        if (userId != null) {
            list = repository.findByUserId(userId);
        } else if (expenseAmount != null) {
            list = repository.findByexpenseAmount(expenseAmount); // Assuming this is the correct method name
        } else if (billNumber!=null){
            list = repository.findBybillNumber(billNumber);
        }else {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        List<ExpenseResponse> responses = new ArrayList<>();

        if (list != null && !list.isEmpty()) {
            for (Expense expense : list) {
                responses.add(setResponse(expense));
            }
        } else {
            throw new NoSuchElementException("No matching records found");
        }

        return responses;
    }
    @Override
    public ExpenseResponse updateExpense(ExpenseRequest expenseRequest) {


        if (expenseRequest != null) {
            int count = repository.countbillNumber(expenseRequest.getBillNumber());
            if (count == 0) {
                Expense expense = repository.findById(expenseRequest.getId()).get();
                expense.setExpenseDescription(expenseRequest.getExpenseDescription());
                expense.setBillNumber(expenseRequest.getBillNumber());

                expense = repository.save(expense);

                return setResponse(expense);
            } else {
                throw new NumberFormatException();
            }
        }
        return null;
    }
}
