package com.isyspad.loanApp.repository;

import com.isyspad.loanApp.entity.DueCollectioent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DueRepository extends JpaRepository<DueCollectioent,Long> {
    List<DueCollectioent> findByduepaiddate(LocalDate due_paid_date );

    List<DueCollectioent>findByduestatus(String duestatus);
}
