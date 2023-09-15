package com.isyspad.loanApp.service;

import com.isyspad.loanApp.entity.Investment;
import com.isyspad.loanApp.model.InvestmentRequest;
import com.isyspad.loanApp.model.InvestmentResponse;

import java.util.Date;
import java.util.List;

public interface InvestmentService {

    String generateInvestmentId(String investmentType, String maxInvestmentId);
    InvestmentResponse createInvestment(InvestmentRequest investmentRequest);
    Investment findInvestmentById(Long id);
    List<InvestmentResponse> findByFields(String investmentType, Double investmentAmount,
                                          Date investmentDate, Integer investmentTermMonths, String investmentStatus);
    InvestmentResponse updateInvestmentById(InvestmentRequest investmentRequest);
}
