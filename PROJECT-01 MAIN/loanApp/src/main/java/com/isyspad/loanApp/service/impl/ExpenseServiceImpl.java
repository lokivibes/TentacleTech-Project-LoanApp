package com.isyspad.loanApp.service.impl;

import com.isyspad.loanApp.entity.EntityExp;
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
    public EntityExp setrequest(ExpenseRequest request) {
        EntityExp entityExp = new EntityExp();
        EntityExp lastSavedEntity = repository.findLastSavedEntity();
        Float currentExpenseAmount = request.getExpenseAmount();
        Float totalExpenseAmount = (lastSavedEntity != null) ? lastSavedEntity.getTotalExpenseAmount() : 0;
        totalExpenseAmount = totalExpenseAmount + currentExpenseAmount;
        Float newRemainingBalance = request.getTotalAmount() - totalExpenseAmount;


        entityExp.setBillNumber(request.getBillNumber());
        entityExp.setExpenseDate(request.getExpenseDate());
        entityExp.setTotalExpenseAmount(totalExpenseAmount);
        entityExp.setTotalAmount(request.getTotalAmount());
        entityExp.setId(request.getId());
        entityExp.setRemainingBalance(newRemainingBalance);
        entityExp.setExpenseDescription(request.getExpenseDescription());
        entityExp.setExpenseAmount(request.getExpenseAmount());
        entityExp.setUserId(request.getUserId());
        return entityExp;
    }

    public ExpenseResponse setResponse(EntityExp entity) {
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
        EntityExp entityExp;
        if (basicvalidation(input)) {

            entityExp = setrequest(input);
            entityExp = repository.save(entityExp);
            return setResponse(entityExp);

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

        List<EntityExp> list = new ArrayList<>();

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
            for (EntityExp entityExp : list) {
                responses.add(setResponse(entityExp));
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
                EntityExp entityExp = repository.findById(expenseRequest.getId()).get();
                entityExp.setExpenseDescription(expenseRequest.getExpenseDescription());
                entityExp.setBillNumber(expenseRequest.getBillNumber());

                entityExp = repository.save(entityExp);

                return setResponse(entityExp);
            } else {
                throw new NumberFormatException();
            }
        }
        return null;
    }
}
