package com.isyspad.loanApp.repository;

import com.isyspad.loanApp.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query("SELECT e FROM Expense e WHERE e.id = (SELECT MAX(id) FROM Expense)")
    Expense findLastSavedEntity();

    @Query(value = "SELECT COUNT(*) FROM Expense WHERE billNumber = ?1")
    int countbillNumber(String billNumber);


    List<Expense> findByexpenseAmount(Float expenseAmount);

    List<Expense> findBybillNumber(String billNumber);

    List<Expense> findByUserId(String userId);




}
