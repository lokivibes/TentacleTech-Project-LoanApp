package com.isyspad.loanApp.service.impl;

import com.isyspad.loanApp.entity.Investment;
import com.isyspad.loanApp.model.InvestmentRequest;
import com.isyspad.loanApp.model.InvestmentResponse;
import com.isyspad.loanApp.repository.InvestmentRepository;
import com.isyspad.loanApp.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    private final InvestmentRepository investmentRepository;
    @Autowired
    public InvestmentServiceImpl(InvestmentRepository investmentRepository){
        this.investmentRepository=investmentRepository;
    }

    // GENERATES UNIQUE INVESTMENT ID BASED ON INVESTMENT TYPE
    @Override
    public String generateInvestmentId(String investmentType, String maxInvestmentId) {
        int currentId = 1;

        if (maxInvestmentId != null) {
            currentId = Integer.parseInt(maxInvestmentId.substring(1)) + 1;
        }

        String formattedInvestmentId = investmentType.substring(0, 1).toUpperCase() + String.format("%04d", currentId);

        return formattedInvestmentId;
    }

    // CREATE
    @Override
    public InvestmentResponse createInvestment(InvestmentRequest investmentRequest) {

        Investment investment = new Investment();

        if(nullValidation(investmentRequest) == true) {

            investment = setInvestmentRequest(investmentRequest);

            String investmentType = investment.getInvestmentType();
            String maxInvestmentId = investmentRepository.findMaxInvestmentIdByInvestmentType(investmentType);
            String formattedInvestmentId = generateInvestmentId(investmentType, maxInvestmentId);

            investment.setInvestmentId(formattedInvestmentId);

            Double interestEarned = calculateInterestEarned(investment);
            if(interestEarned != null) {
                investment.setInterestEarned(interestEarned);
            }else{
                throw new NullPointerException();
            }

            Double investmentRatio = calculateInvestmentRatio(investment);
            if(investmentRatio != null) {
                investment.setInvestmentRatio(investmentRatio);
            }else{
                throw new NullPointerException();
            }

            investment = investmentRepository.save(investment);

            return setInvestmentResponse(investment);
        }
        else{
            throw new NullPointerException();
        }
    }

    // INTEREST CALCULATION
    public Double calculateInterestEarned(Investment investment){
        return (investment.getInvestmentAmount()*investment.getInterestRate()*investment.getInvestmentTermMonths())/(12*100);
    }

    // RATIO CALCULATION
    public Double calculateInvestmentRatio(Investment investment) {
        return (investment.getInterestEarned() / investment.getInvestmentAmount())* 100;
    }

    // NULL VALIDATION
    public boolean nullValidation(InvestmentRequest investmentRequest){
        if(investmentRequest.getInvestorName() != null &&
                investmentRequest.getInvestmentType() != null && investmentRequest.getInvestmentAmount() != null &&
                investmentRequest.getInvestmentDate() != null && investmentRequest.getInvestmentTermMonths() != null &&
                investmentRequest.getInvestmentStatus() != null && investmentRequest.getInterestRate() != null){
            return true;
        }
        else {
            return false;
        }
    }

    // REQUEST TO ENTITY
    public Investment setInvestmentRequest(InvestmentRequest investmentRequest){

        Investment investment = new Investment();

        investment.setInvestorName(investmentRequest.getInvestorName());
        investment.setInvestmentType(investmentRequest.getInvestmentType());
        investment.setInvestmentAmount(investmentRequest.getInvestmentAmount());
        investment.setInvestmentDate(investmentRequest.getInvestmentDate());
        investment.setInvestmentTermMonths(investmentRequest.getInvestmentTermMonths());
        investment.setInvestmentStatus(investmentRequest.getInvestmentStatus());
        investment.setInterestRate(investmentRequest.getInterestRate());

        return investment;
    }

    // ENTITY TO RESPONSE
    public InvestmentResponse setInvestmentResponse(Investment investment){

        InvestmentResponse investmentResponse = new InvestmentResponse();

        investmentResponse.setId(investment.getId());
        investmentResponse.setInvestorName(investment.getInvestorName());
        investmentResponse.setInvestmentType(investment.getInvestmentType());
        investmentResponse.setInvestmentId(investment.getInvestmentId());
        investmentResponse.setInvestmentAmount(investment.getInvestmentAmount());
        investmentResponse.setInvestmentDate(investment.getInvestmentDate());
        investmentResponse.setInvestmentTermMonths(investment.getInvestmentTermMonths());
        investmentResponse.setInvestmentStatus(investment.getInvestmentStatus());
        investmentResponse.setInterestRate(investment.getInterestRate());
        investmentResponse.setInterestEarned(investment.getInterestEarned());
        investmentResponse.setInvestmentRatio(investment.getInvestmentRatio());

        return investmentResponse;
    }

    // FIND
    @Override
    public Investment findInvestmentById(Long id) {
        return investmentRepository.findById(id).orElse(null);
    }

    // FIND USING DIFFERENT FIELDS
    @Override
    public List<InvestmentResponse> findByFields(String investmentType, Double investmentAmount, Date investmentDate, Integer investmentTermMonths, String investmentStatus) {

        List<Investment> investmentList = new ArrayList<>();

        if (investmentType != null) {
            investmentList = investmentRepository.findByInvestmentType(investmentType);
        } else if (investmentAmount != null) {
            investmentList = investmentRepository.findByInvestmentAmount(investmentAmount);
        } else if (investmentTermMonths != null){
            investmentList = investmentRepository.findByInvestmentTermMonths(investmentTermMonths);
        } else if (investmentDate != null){
            investmentList = investmentRepository.findByInvestmentDate(investmentDate);
        } else if (investmentStatus != null){
            investmentList = investmentRepository.findByInvestmentStatus(investmentStatus);
        } else {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        List<InvestmentResponse> investmentListResult = new ArrayList<>();

        if (investmentList != null && !investmentList.isEmpty()) {
            for (Investment investment : investmentList) {
                investmentListResult.add(setInvestmentResponse(investment));
            }
        } else {
            throw new NoSuchElementException("No matching records found");
        }

        return investmentListResult;
    }

    // UPDATE
    @Override
    public InvestmentResponse updateInvestmentById(InvestmentRequest investmentRequest) {

        if(investmentRequest!=null) {

            Investment investment = investmentRepository.findById(investmentRequest.getId()).get();

            investment.setInvestorName(investmentRequest.getInvestorName());
            investment.setInvestmentType(investmentRequest.getInvestmentType());
            investment.setInvestmentDate(investmentRequest.getInvestmentDate());
            investment.setInvestmentStatus(investmentRequest.getInvestmentStatus());

            investment = investmentRepository.save(investment);

            return setInvestmentResponse(investment);
        } else {
            throw new NullPointerException();
        }
    }

}
