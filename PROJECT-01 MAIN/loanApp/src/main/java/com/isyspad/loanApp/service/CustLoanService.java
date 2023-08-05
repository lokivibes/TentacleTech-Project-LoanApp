package com.isyspad.loanApp.service;


import com.isyspad.loanApp.entity.CustomerLoan;

import java.util.List;
//import java.util.List;

public interface CustLoanService {

//-------------------------------------- LOKKI - UPDATE Customer Table ---------------------------------------------//


      CustomerLoan getCustomersById(String custId) ;

      CustomerLoan updateCustomerLoan(String custId,CustomerLoan customerLoan) ;

      List<CustomerLoan> getAll() ;

      void deleteCustomerById(String custId) ;


//-------------------------------------- GOKULNATH - CREATE Customer Table -----------------------------------------//

     CustomerLoan saveLoanWithIncrementedID(CustomerLoan loan);


//------------------------------------------ KANMANI - Customer Table Find  ----------------------------------------//


     List<CustomerLoan> findLoansByCustomerIdAndLoanId(String custId, String loanId);


}
