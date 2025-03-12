package com.example.rewards.repository;

import com.example.rewards.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    /**
     * Finds all transactions for a given customer within a specific date range.
     *
     * @param customerId The ID of the customer
     * @param startDate  The start date for filtering transactions
     * @param endDate    The end date for filtering transactions
     * @return List of transactions matching the criteria
     */
    List<Transaction> findByCustomerIdAndTransactionDateBetween(Long customerId, LocalDate startDate, LocalDate endDate);
}
