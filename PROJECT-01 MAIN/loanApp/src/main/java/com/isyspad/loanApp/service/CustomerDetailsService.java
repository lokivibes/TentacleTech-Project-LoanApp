package com.isyspad.loanApp.service;

import com.isyspad.loanApp.entity.CustomerDetails;
import com.isyspad.loanApp.model.CustomerDetailsReq;
import com.isyspad.loanApp.model.CustomerDetailsResponse;

import javax.naming.ContextNotEmptyException;
import java.text.ParseException;
import java.util.List;

public interface CustomerDetailsService {

    // CREATE CUSTOMER -- ANASOOYA MURALI
    public CustomerDetailsResponse createCustomer(CustomerDetailsReq customerDetails);
//    public CustomerDetailsResponse createCustId(CustomerDetailsReq customerDetails);

    // FIND CUSTOMER -- NAVEENKUMAR K
    List<CustomerDetailsResponse> getCustomer(Long ph_num, String cust_Id, Long ph_num2, String name, String father_name);

    // UPDATE CUSTOMER -- GOPI VIVEK
    public CustomerDetails updateCustomer(String custId, String fieldName, String fieldValue, CustomerDetails customerRequest);
}
