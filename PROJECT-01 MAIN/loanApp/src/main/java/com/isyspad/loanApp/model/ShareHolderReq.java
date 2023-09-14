package com.isyspad.loanApp.model;

import java.time.LocalDate;

public class ShareHolderReq {
    private Long id;
    private String userid;
    private String shareHolderName;
    private String fatherName;
    private String spouseName;
    private String address;
    private Long phNum1;
    private Long phNum2;
    private Long investedAmount;
    private LocalDate createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getShareHolderName() {
        return shareHolderName;
    }

    public void setShareHolderName(String shareHolderName) {
        this.shareHolderName = shareHolderName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhNum1() {
        return phNum1;
    }

    public void setPhNum1(Long phNum1) {
        this.phNum1 = phNum1;
    }

    public Long getPhNum2() {
        return phNum2;
    }

    public void setPhNum2(Long phNum2) {
        this.phNum2 = phNum2;
    }

    public Long getInvestedAmount() {
        return investedAmount;
    }

    public void setInvestedAmount(Long investedAmount) {
        this.investedAmount = investedAmount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
