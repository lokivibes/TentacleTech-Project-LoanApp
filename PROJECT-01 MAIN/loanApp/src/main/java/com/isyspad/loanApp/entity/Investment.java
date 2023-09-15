package com.isyspad.loanApp.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Investment")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;                        // Unique identifier for the investment
    private String investorName;            // Name of the investor
    private String investmentType;          // Type of investment (e.g., stocks, bonds, real estate)
    private String investmentId;            // Unique Investment ID based on Investment Type
    private Double investmentAmount;        // Total amount of money invested
    private Date investmentDate;            // Date when the investment was made
    private Integer investmentTermMonths;   // Term of the investment in months
    private String investmentStatus;        // Status of the investment (e.g., "Active," "Closed," "Pending")
    private Float interestRate;             // Interest rate associated with the investment
    private Double interestEarned;          // Amount of interest earned on the investment
    private Double investmentRatio;         // Investment ratio or percentage

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
