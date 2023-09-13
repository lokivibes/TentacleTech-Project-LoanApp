package com.isyspad.loanApp.controller;

import com.isyspad.loanApp.entity.CustomerDetails;
import com.isyspad.loanApp.model.CustomerDetailsReq;
import com.isyspad.loanApp.model.CustomerDetailsResponse;
import com.isyspad.loanApp.repository.CustomerDetailsRepository;
import com.isyspad.loanApp.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerDetailsController {
    //private int currentId = 1;
    @Autowired
    private CustomerDetailsService customerDetailsService;
    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    // CREATE CUSTOMER -- ANASOOYA MURALI
    @PostMapping("/CustomerDetails")
    public ResponseEntity<CustomerDetailsResponse>createandsave(@RequestBody CustomerDetailsReq customerDetails){

//    CustomerDetailsResponse finalresult = customerDetailsService.createCustId(customerDetails);
    CustomerDetailsResponse finalrespo = customerDetailsService.createCustomer(customerDetails);
    return  new ResponseEntity<>(finalrespo,HttpStatus.CREATED);
}

    // FIND CUSTOMER -- NAVEENKUMAR K
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDetailsResponse>> getCustomer(@RequestParam(required = false) Long ph_num,
                                                                     @RequestParam(required = false) String cust_Id,
                                                                     @RequestParam(required = false) Long ph_num2,
                                                                     @RequestParam(required = false) String name,
                                                                     @RequestParam(required = false) String father_name) {
        List<CustomerDetailsResponse> resp = customerDetailsService.getCustomer(ph_num, cust_Id, ph_num2, name, father_name);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


    // UPDATE CUSTOMER -- GOPI VIVEK

    @PutMapping("/update/{custId}")
    public ResponseEntity<CustomerDetails> updateCustomer(
            @PathVariable("custId") String custId,
            @RequestParam("fieldName") String fieldName,
            @RequestParam("fieldValue") String fieldValue, CustomerDetails customerRequest){

        CustomerDetails entity = customerDetailsService.updateCustomer(custId, fieldName, fieldValue, customerRequest);
        return ResponseEntity.ok(entity);
    }
}
