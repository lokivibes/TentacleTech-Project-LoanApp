package com.isyspad.loanApp.repository;

import com.isyspad.loanApp.entity.CustomerLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface CustLoanRepository extends JpaRepository<CustomerLoan,Long> {

//----------------------------------------- LOKKI - UPDATE Customer Table -----------------------------------------//
    //-- Using method for get customer ID
    CustomerLoan findByCustId(String custId);


//--------------------------------------- GOKULNATH - CREATE Customer Table -----------------------------------------//
    //-- Using query for loan ID Auto Increment
    @Query(value = "SELECT MAX(loanId) FROM CustomerLoan WHERE loan_type=?1")
    String findMaxLoanIdByLoanType(String loan_type);


//------------------------------------------ KANMANI - Customer Table Find  --------------------------------------------//
    //-- Using method for get loan ID and Customer ID
    List<CustomerLoan> findByCustIdAndLoanId(@Param("custId") String custId, @Param("loanId") String loanId);


}
