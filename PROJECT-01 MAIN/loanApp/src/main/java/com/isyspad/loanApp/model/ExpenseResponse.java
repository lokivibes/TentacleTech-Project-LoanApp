package com.isyspad.loanApp.model;

import java.util.Date;

public class ExpenseResponse {

    private Long id;

    private String userId;

    private Float expenseAmonut;

    private String expenseDescription;

    private Date expenseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Float getExpenseAmonut() {
        return expenseAmonut;
    }

    public void setExpenseAmonut(Float expenseAmonut) {
        this.expenseAmonut = expenseAmonut;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    private Float totalExpenseAmount;
    private Float totalAmount;

    private Float remainingBalance;

    private  String billNumber;

    public Float getTotalExpenseAmount() {
        return totalExpenseAmount;
    }

    public void setTotalExpenseAmount(Float totalExpenseAmount) {
        this.totalExpenseAmount = totalExpenseAmount;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Float getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(Float remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
}
