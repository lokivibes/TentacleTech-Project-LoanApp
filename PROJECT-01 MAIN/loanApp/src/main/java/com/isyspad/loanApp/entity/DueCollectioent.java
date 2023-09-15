package com.isyspad.loanApp.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "due_collectioent")
public class DueCollectioent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    private Long cust_id;
    private Long loan_id;
    private Float due_amount;
//    @Column
//    @UpdateTimestamp

    private LocalDate due_date;
    @Column(name="due_paid_date")
    private LocalDate duepaiddate;
    private Float due_paid_amount;



    private double due_pending_amount;
    @Column(name = "due_status")
    private String duestatus;
    private LocalDate create_date;

    private LocalDate last_update_date;

    private String created_by;
    private String last_update_by;



    public Float getDue_amount() {
        return due_amount;
    }

    public void setDue_amount(Float due_amount) {
        this.due_amount = due_amount;
    }


    public Float getDue_paid_amount() {
        return due_paid_amount;
    }

    public void setDue_paid_amount(Float due_paid_amount) {
        this.due_paid_amount = due_paid_amount;
    }



    public String getDuestatus() {
        return duestatus;
    }

    public void setDuestatus(String duestatus) {
        this.duestatus = duestatus;
    }


    public double getDue_pending_amount() {
        return due_pending_amount;
    }

    public void setDue_pending_amount(double due_pending_amount) {
        this.due_pending_amount = due_pending_amount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public Long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Long loan_id) {
        this.loan_id = loan_id;
    }




    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }








    public LocalDate getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public LocalDate getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(LocalDate last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(String last_update_by) {
        this.last_update_by = last_update_by;
    }
    public LocalDate getDuepaiddate() {
        return duepaiddate;
    }

    public void setDuepaiddate(LocalDate duepaiddate) {
        this.duepaiddate = duepaiddate;
    }


}
