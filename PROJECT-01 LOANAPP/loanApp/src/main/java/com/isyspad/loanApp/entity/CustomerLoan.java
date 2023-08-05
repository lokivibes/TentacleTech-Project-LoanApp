package com.isyspad.loanApp.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerLoan {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "id")
    private Long id;

    @Column(name = "loan_id", nullable = false)
    private String loanId;

    @Column(name = "cust_id",nullable = false)
    private String custId;
    @Column(name = "loan_type")
    private String loan_type;
    @Column(name = "loan_amount")
    private double loan_amount;
    @Column(name = "interest_rate")
    private int interest_rate;
    @Column(name = "loan_tenure")
    private int loan_tenure;
    @Column(name = "due_count")
    private int due_count;
    @Column(name = "due_amount")
    private int due_amount;

    @Column(name = "due_date")
    private LocalDateTime due_date;
    @Column(name = "due_end_date")
    private LocalDateTime due_end_date;
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime created_date;
    @Column(name = "last_updated_date")
    @UpdateTimestamp
    private LocalDateTime last_updated_date;
    @Column(name = "created_by")
    private String created_by;
    @Column(name = "last_updated_by")
    private String last_updated_by;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLoanid() {
        return loanId;
    }

    public void setLoanid(String loanid) {
        this.loanId = loanid;
    }

    public String getCustid() {
        return custId;
    }

    public void setCustid(String custid) {
        this.custId = custid;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public int getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(int interest_rate) {
        this.interest_rate = interest_rate;
    }

    public int getLoan_tenure() {
        return loan_tenure;
    }

    public void setLoan_tenure(int loan_tenure) {
        this.loan_tenure = loan_tenure;
    }

    public int getDue_count() {
        return due_count;
    }

    public void setDue_count(int due_count) {
        this.due_count = due_count;
    }

    public int getDue_amount() {
        return due_amount;
    }

    public void setDue_amount(int due_amount) {
        this.due_amount = due_amount;
    }

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }

    public LocalDateTime getDue_end_date() {
        return due_end_date;
    }

    public void setDue_end_date(LocalDateTime due_end_date) {
        this.due_end_date = due_end_date;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getLast_updated_date() {
        return last_updated_date;
    }

    public void setLast_updated_date(LocalDateTime last_updated_date) {
        this.last_updated_date = last_updated_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getLast_updated_by() {
        return last_updated_by;
    }

    public void setLast_updated_by(String last_updated_by) {
        this.last_updated_by = last_updated_by;
    }



    public CustomerLoan(Long id, String loanId, String custId, String loan_type, double loan_amount, int interest_rate, int loan_tenure, int due_count, int due_amount, LocalDateTime due_date, LocalDateTime due_end_date, LocalDateTime created_date, LocalDateTime last_updated_date, String created_by, String last_updated_by) {
        this.id = id;
        this.loanId = loanId;
        this.custId = custId;
        this.loan_type = loan_type;
        this.loan_amount = loan_amount;
        this.interest_rate = interest_rate;
        this.loan_tenure = loan_tenure;
        this.due_count = due_count;
        this.due_amount = due_amount;
        this.due_date = due_date;
        this.due_end_date = due_end_date;
        this.created_date = created_date;
        this.last_updated_date = last_updated_date;
        this.created_by = created_by;
        this.last_updated_by = last_updated_by;
    }


    public CustomerLoan()
    {

    }

    @Override
    public String toString() {
        return "Customer{}";
    }
}
