package com.isyspad.loanApp.model;

import java.util.Date;

public class ExpenseRequest {

    private Long id;

    private String userId;

    private Float expenseAmount;

    private String expenseDescription;

    private Date expenseDate;

    private Float totalAmount;

    private Float remainingBalance;

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

    public Float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Float expenseAmount) {
        this.expenseAmount = expenseAmount;
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

    private float  totalExpenseAmount;
    private  String billNumber;

    public float getTotalExpenseAmount() {
        return totalExpenseAmount;
    }

    public void setTotalExpenseAmount(float totalExpenseAmount) {
        this.totalExpenseAmount = totalExpenseAmount;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }
}
