package com.isyspad.loanApp.controller;

import com.isyspad.loanApp.entity.Investment;
import com.isyspad.loanApp.model.InvestmentRequest;
import com.isyspad.loanApp.model.InvestmentResponse;
import com.isyspad.loanApp.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/invest")
public class InvestmentController {

    private final InvestmentService investmentService;
    @Autowired
    public InvestmentController(InvestmentService investmentService){
        this.investmentService=investmentService;
    }
    @PostMapping("/investcreate")
    public ResponseEntity<InvestmentResponse> createInvestment(@RequestBody InvestmentRequest investmentRequest){
        InvestmentResponse investmentResponse = investmentService.createInvestment(investmentRequest);
        return new ResponseEntity<>(investmentResponse, HttpStatus.CREATED);
    }
    @GetMapping("/investfind/{id}")
    public ResponseEntity<Investment> findById(@PathVariable Long id){
        Investment investment = investmentService.findInvestmentById(id);
        return new ResponseEntity<>(investment, HttpStatus.FOUND);
    }
    @GetMapping("/investFind")
    public ResponseEntity<List<InvestmentResponse>> findByFieldMembers(@RequestParam(required = false) String investmentType, Double investmentAmount,
                                                                       Integer investmentTermMonths, Date investmentDate, String investmentStatus ){
        List<InvestmentResponse> investmentResponseList = investmentService.findByFields(investmentType,investmentAmount, investmentDate,
                investmentTermMonths,investmentStatus);
        return new ResponseEntity<>(investmentResponseList, HttpStatus.FOUND);
    }
    @PutMapping("/investupdate")
    public ResponseEntity<InvestmentResponse> updateInvestmentById(@RequestBody InvestmentRequest investmentRequest ){
        InvestmentResponse investmentResponse = investmentService.updateInvestmentById(investmentRequest);
        return new ResponseEntity<>(investmentResponse, HttpStatus.OK);
    }
}
