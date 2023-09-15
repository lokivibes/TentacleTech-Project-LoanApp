package com.isyspad.loanApp.repository;

import com.isyspad.loanApp.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long>  {

    @Query("SELECT MAX(i.investmentId) FROM Investment i WHERE i.investmentType = ?1")
    String findMaxInvestmentIdByInvestmentType(String investmentType);
    List<Investment> findByInvestmentType(String investmentType);
    List<Investment> findByInvestmentAmount(Double investmentAmount);
    List<Investment> findByInvestmentTermMonths(Integer investmentTermMonths);
    List<Investment> findByInvestmentDate(Date investmentDate);
    List<Investment> findByInvestmentStatus(String investmentStatus);
}
