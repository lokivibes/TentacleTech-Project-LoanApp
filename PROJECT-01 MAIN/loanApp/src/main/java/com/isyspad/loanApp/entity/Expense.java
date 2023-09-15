package com.isyspad.loanApp.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table(name = "ExpenseTrackerTable")
@javax.persistence.Entity
public class Expense {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Float expenseAmount;

    private String expenseDescription;
    @CreationTimestamp
    private Date expenseDate;

    private Float totalExpenseAmount;

    public Float getTotalExpenseAmount() {
        return totalExpenseAmount;
    }

    public void setTotalExpenseAmount(Float totalExpenseAmount) {
        this.totalExpenseAmount = totalExpenseAmount;
    }

    private Float totalAmount;

    private Float remainingBalance;

    private String billNumber;

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

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }
}
