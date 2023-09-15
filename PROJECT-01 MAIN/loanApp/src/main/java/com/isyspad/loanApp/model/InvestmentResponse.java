package com.isyspad.loanApp.model;

import java.util.Date;

public class InvestmentResponse {

    private Long id;
    private String investorName;
    private String investmentType;
    private String investmentId;
    private Double investmentAmount;
    private Date investmentDate;
    private Integer investmentTermMonths;
    private String investmentStatus;
    private Float interestRate;
    private Double interestEarned;
    private Double investmentRatio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investmentId) {
        this.investmentId = investmentId;
    }

    public Double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Date getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(Date investmentDate) {
        this.investmentDate = investmentDate;
    }

    public Integer getInvestmentTermMonths() {
        return investmentTermMonths;
    }

    public void setInvestmentTermMonths(Integer investmentTermMonths) {
        this.investmentTermMonths = investmentTermMonths;
    }

    public String getInvestmentStatus() {
        return investmentStatus;
    }

    public void setInvestmentStatus(String investmentStatus) {
        this.investmentStatus = investmentStatus;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public Double getInterestEarned() {
        return interestEarned;
    }

    public void setInterestEarned(Double interestEarned) {
        this.interestEarned = interestEarned;
    }

    public Double getInvestmentRatio() {
        return investmentRatio;
    }

    public void setInvestmentRatio(Double investmentRatio) {
        this.investmentRatio = investmentRatio;
    }
}
