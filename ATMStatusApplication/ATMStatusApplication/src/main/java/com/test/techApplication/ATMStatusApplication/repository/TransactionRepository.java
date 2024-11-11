package com.test.techApplication.ATMStatusApplication.repository;


import com.test.techApplication.ATMStatusApplication.Entitty.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Count distinct customers (by customerId) who have transactions in the last 24 hours
    long countDistinctByTimestampAfter(LocalDateTime timestamp);

    // Find transactions after a certain timestamp
    List<Transaction> findByTimestampAfter(LocalDateTime timestamp);
}
