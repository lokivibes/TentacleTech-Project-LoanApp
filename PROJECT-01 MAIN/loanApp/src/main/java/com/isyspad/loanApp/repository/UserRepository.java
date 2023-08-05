package com.isyspad.loanApp.repository;

import com.isyspad.loanApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findById(Long id);

    @Query(value = "SELECT COUNT(*) FROM User WHERE userName = ?1")
    int countByUsername(String userName);

}
