package com.isyspad.loanApp.repository;


import com.isyspad.loanApp.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,String> {
    @Query(value = "SELECT MAX(custId) FROM CustomerDetails")
        String findMaxCustId();



    // FIND CUSTOMER -- NAVEENKUMAR K
    List<CustomerDetails> findByCustId(String custId);
    List<CustomerDetails> findByName(String name);
    List<CustomerDetails> findByFatherName(String father_name);
    List<CustomerDetails> findByPhNum(Long phNum);
    List<CustomerDetails> findByPhNum2(Long phNum2);
    List<CustomerDetails> findByNameAndFatherName(String name, String father_name );

}
