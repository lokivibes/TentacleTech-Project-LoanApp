package com.isyspad.loanApp.service.impl;


import com.isyspad.loanApp.entity.CustomerLoan;
import com.isyspad.loanApp.repository.CustLoanRepository;
import com.isyspad.loanApp.service.CustLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustLoanServiceImpl implements CustLoanService {
@Autowired
    private CustLoanRepository custLoanRepository;

    @Autowired
    public CustLoanServiceImpl(CustLoanRepository custLoanRepository) {
        this.custLoanRepository = custLoanRepository;
    }


//----------------------------------------- LOKKI - UPDATE Customer Table -----------------------------------------//

         //-- GET CUSTOMER ID LOGIC --//
    @Override
    public CustomerLoan getCustomersById(String custId)
    {
        try {

            return custLoanRepository.findByCustId(custId);
        }
        catch(NullPointerException ex) {
           ex.printStackTrace();
            throw new NullPointerException(ex.getMessage());
    }

    }

         //-- UPDATE CUSTOMER TABLE ALL ENTITY USING UNIQUE CUSTOMER ID LOGIC ---//
    @Override
    public CustomerLoan updateCustomerLoan (String custId,CustomerLoan customerLoan)
    {
        if(custId.isEmpty())
        {
            throw new NoSuchElementException("Customer not found with ID:"+custId);
        }
        else {
            CustomerLoan newCustomer = custLoanRepository.findByCustId(custId);

            if (customerLoan.getLoanid() != null) {
                newCustomer.setLoanid(customerLoan.getLoanid());
            }
            if (customerLoan.getCustid() != null) {
                newCustomer.setCustid(customerLoan.getCustid());
            }
            if (customerLoan.getLoan_amount() != 0.0) {
                newCustomer.setLoan_amount(customerLoan.getLoan_amount());
            }
            if (customerLoan.getLoan_type() != null) {
                newCustomer.setLoan_type(customerLoan.getLoan_type());
            }
            if (customerLoan.getLoan_tenure() != 0) {
                newCustomer.setLoan_tenure(customerLoan.getLoan_tenure());
            }
            if (customerLoan.getDue_amount() != 0) {
                newCustomer.setDue_amount(customerLoan.getDue_amount());
            }
            if (customerLoan.getDue_count() != 0) {
                newCustomer.setDue_count(customerLoan.getDue_count());
            }
            if (customerLoan.getDue_date() != null) {
                newCustomer.setDue_date(customerLoan.getDue_date());
            }
            if (customerLoan.getDue_end_date() != null) {
                newCustomer.setDue_end_date(customerLoan.getDue_end_date());
            }
            if (customerLoan.getCreated_by() != null) {
                newCustomer.setCreated_by(customerLoan.getCreated_by());
            }
            if (customerLoan.getLast_updated_by() != null) {
                newCustomer.setLast_updated_by(customerLoan.getLast_updated_by());
            }
            return custLoanRepository.save(newCustomer);
        }
    }

    //-- GET ALL ROW ENTRIES IN THE DATABASE LOGIC ---//
    @Override
    public List<CustomerLoan> getAll() {
        try {
            return (List<CustomerLoan>) custLoanRepository.findAll();
        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
            throw new NullPointerException(ex.getMessage());
        }
    }

    //-- DELETE ROW IN THE DATABASE USING UNIQUE CUSTOMER ID LOGIC ---//
    @Override
    public void deleteCustomerById(String custId)
    {
           try {
               CustomerLoan deleteId = custLoanRepository.findByCustId(custId);
               if (deleteId != null) {
                   custLoanRepository.delete(deleteId);
               }
           }
           catch (NullPointerException ex)
           {
               ex.printStackTrace();
               throw new NullPointerException(ex.getMessage());
           }

    }



//---------------------------------------- GOKULNATH - CREATE Customer table --------------------------------------//

    //-- CREATE ALL ENTRIES IN THE DATABASE TABLE LOGIC ---//
    @Override
    public CustomerLoan saveLoanWithIncrementedID(CustomerLoan loan) {

        CustomerLoan addloan = new CustomerLoan();

        String loanType = loan.getLoan_type();

        String maxLoanId = custLoanRepository.findMaxLoanIdByLoanType(loanType);

        String firstLetter = loanType.substring(0,1).toUpperCase();

        int currentId;

        if (maxLoanId != null) {
            currentId = Integer.parseInt(maxLoanId.substring(loanType.length()))+1;
        } else {
            currentId=1;
        }

        String loanId = firstLetter+String.format("%04d", currentId);
        loan.setLoanid(loanId);

        if(loan.getCustid()!=null && loan.getLoan_type()!=null && loan.getLoan_amount()!= 0 &&
                loan.getInterest_rate()!= 0 && loan.getLoan_tenure()!= 0 && loan.getDue_date()!=null &&
                loan.getDue_amount()!= 0 && loan.getDue_date()!=null && loan.getDue_end_date()!=null &&
                loan.getCreated_date()!=null && loan.getLast_updated_date()!=null &&
                loan.getCreated_by()!=null && loan.getLast_updated_by()!=null) {

            addloan.setId(loan.getId());
            addloan.setLoan_type(loan.getLoan_type());
            addloan.setLoanid(loan.getLoanid());
            addloan.setCustid(loan.getCustid());
            addloan.setLoan_amount(loan.getLoan_amount());
            addloan.setInterest_rate(loan.getInterest_rate());
            addloan.setLoan_tenure(loan.getLoan_tenure());
            addloan.setDue_count(loan.getDue_count());
            addloan.setDue_amount(loan.getDue_amount());
            addloan.setDue_date(loan.getDue_date());
            addloan.setDue_end_date(loan.getDue_end_date());
            addloan.setLast_updated_date(loan.getLast_updated_date());
            addloan.setCreated_by(loan.getCreated_by());
            addloan.setLast_updated_by(loan.getLast_updated_by());

            custLoanRepository.save(addloan);
        }else {
            throw new NullPointerException();
        }
        return loan;
    }


//-------------------------------------- KANMANI - Customer Table Find  -------------------------------------------//

    //-- FINDING UNIQUE CUSTOMER DETAILS WITH SPECIFIC TWO ENTITY AS CUSTOMER ID AND LOAN ID --//
    @Override
    public List<CustomerLoan> findLoansByCustomerIdAndLoanId(String custId, String loanId) {
        return custLoanRepository.findByCustIdAndLoanId(custId, loanId);
    }

}
