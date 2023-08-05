package com.isyspad.loanApp.controller;

import com.isyspad.loanApp.entity.CustomerLoan;
import com.isyspad.loanApp.exception.LoanNotFoundException;
import com.isyspad.loanApp.service.CustLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class CustLoanController {
    @Autowired
    private CustLoanService custLoanService;

    @Autowired
    public CustLoanController(CustLoanService custLoanService) {
        this.custLoanService = custLoanService;
    }

//--------------------------------------- LOKKI - UPDATE Customer Table ----------------------------------------------//

    //----- TEST API -----//
    @GetMapping("/test")
    public String testapi() {
        return "Yellaarum vaangaah..! Alwayss Welcomee..!";
    }

    //----- FETCH by unique customer ID  -----//
    @GetMapping("/getid")
    public ResponseEntity<CustomerLoan> getCustomerLoanByCustId(@RequestBody CustomerLoan reqCustId)  {
        String getCustId = reqCustId.getCustid();
        CustomerLoan getloan = custLoanService.getCustomersById(getCustId);
        if (getloan != null)
        {
            return new ResponseEntity<>(getloan, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //----- UPDATE by unique customer ID through API (After Fetching ID )-----//
    @PutMapping("/update/{custId}")
    public  ResponseEntity<CustomerLoan> updateCustomerByCustId(@PathVariable String custId, @RequestBody CustomerLoan update){
        if(custId.isEmpty())
        {
            throw new LoanNotFoundException("Loan ID " +custId+ "not found");
        }
        else {
            CustomerLoan updatedcustomer = custLoanService.updateCustomerLoan(custId, update);
            return ResponseEntity.ok(updatedcustomer);
        }
    }

    //----- GET ALL ENTRIES IN DATABASE (For refference) -----//
    @GetMapping("/getall")
       public ResponseEntity<List<CustomerLoan>> getAllCustomer() {
        List<CustomerLoan> customers = null;
        try {
            customers = custLoanService.getAll();
        }
        catch (Exception ex) {
            ex.getMessage();
        }
        return new ResponseEntity<List<CustomerLoan>>(customers,HttpStatus.OK);
    }

    //----- DELETE by unique customer ID (For refference) -----//
    @DeleteMapping("/delete/{custId}")
    public ResponseEntity<Void> deleteCustomer(@RequestBody CustomerLoan reqcustId)  {
        String deleteCustId = reqcustId.getCustid();
        if(deleteCustId.isEmpty())
        {
            throw new LoanNotFoundException("Loan with Loan Amount: " + deleteCustId + " not found.");
        }
        else {
            custLoanService.deleteCustomerById(deleteCustId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }



//------------------------------------- GOKULNATH - CREATE Customer Table --------------------------------------------//

    //----- CREATING customer loan details (Auto using ID and loan Id) -----//
    @PostMapping("/create")
    public ResponseEntity<CustomerLoan> createLoan(@RequestBody CustomerLoan cusloan) {
        CustomerLoan savedLoan = custLoanService.saveLoanWithIncrementedID(cusloan);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }



//-------------------------------------- KANMANI - Customer Table Find  ---------------------------------------------//

    //----- FINDING customer loan details by using customer ID and Loan ID -----//
    @GetMapping("/find")
    public ResponseEntity<List<CustomerLoan>> getLoanByCustloan(@RequestBody CustomerLoan request) {

        String custId = request.getCustid();
        String loanId = request.getLoanid();

        List<CustomerLoan> loans = custLoanService.findLoansByCustomerIdAndLoanId(custId, loanId);
        if (loans.isEmpty()) {
            throw new LoanNotFoundException("Loan with Loan Amount: " + custId +
                    " and Interest Rate: " + loanId + " not found.");
        }
        return ResponseEntity.ok(loans);
    }

}

