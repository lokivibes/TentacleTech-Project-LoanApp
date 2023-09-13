package com.isyspad.loanApp.repository;

import com.isyspad.loanApp.entity.EntityExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<EntityExp,Long> {

    @Query("SELECT e FROM EntityExp e WHERE e.id = (SELECT MAX(id) FROM EntityExp)")
    EntityExp findLastSavedEntity();

    @Query(value = "SELECT COUNT(*) FROM EntityExp WHERE billNumber = ?1")
    int countbillNumber(String billNumber);


    List<EntityExp> findByexpenseAmount(Float expenseAmount);

    List<EntityExp> findBybillNumber(String billNumber);

    List<EntityExp> findByUserId(String userId);




}
