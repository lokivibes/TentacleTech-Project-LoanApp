package com.isyspad.loanApp.repository;

import com.isyspad.loanApp.entity.ShareHolderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareHolderRepository extends JpaRepository<ShareHolderDetails,Long> {

    ShareHolderDetails findTopByOrderByIdDesc();
    List<ShareHolderDetails> searchByUserid(String userid);
    List<ShareHolderDetails>searchByShareHolderName(String shareHolderName);
    List<ShareHolderDetails>searchByFatherName(String fatherName);
}
