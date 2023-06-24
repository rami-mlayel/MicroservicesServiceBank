package com.example.transactionservice.repository;

import com.example.transactionservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM ACCOUNT WHERE ACCOUNT_NUMBER = ?1", nativeQuery = true)
    Account findByAccountNumber(String accountNumber);

}
