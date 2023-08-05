package com.isyspad.loanApp.model;

import java.util.Date;

public class CustomerDetailsReq {
    private Long id;
    private String custId;
    private String name;
    private String fatherName;
    private String spouseName;
    private Long intoId;
    private Long phNum;
    private Long phNum2;
    private String address;
    private Date createdDate;
    private Date lastUpdatedDate;
    private String createdBy;
    private String lastUpdatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public Long getIntoId() {
        return intoId;
    }

    public void setIntoId(Long intoId) {
        this.intoId = intoId;
    }

    public Long getPhNum() {
        return phNum;
    }

    public void setPhNum(Long phNum) {
        this.phNum = phNum;
    }

    public Long getPhNum2() {
        return phNum2;
    }

    public void setPhNum2(Long phNum2) {
        this.phNum2 = phNum2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    public Date getLastUpdatedDate() {return lastUpdatedDate;}

    public void setLastUpdatedDate(Date lastUpdatedDate) {this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    }


