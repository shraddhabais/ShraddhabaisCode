package com.example.rewards.service;

import com.example.rewards.exception.CustomerNotFoundException;
import com.example.rewards.exception.InvalidTransactionAmountException;
import com.example.rewards.model.Customer;
import com.example.rewards.dto.MonthlyReward;
import com.example.rewards.dto.RewardsResponse;
import com.example.rewards.model.Transaction;
import com.example.rewards.repository.CustomerRepository;
import com.example.rewards.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CustomerRewardsService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerRepository customerRepository;

    /* Calculates reward points for a given customer over a specified number of months.
       @param customerId The customer ID
     @param months The number of past months to consider (default: 3)
      * @return RewardsResponse containing monthly and total reward points
      */
    public RewardsResponse calculateRewards(Long customerId, int months) {
        Customer customer = customerRepository.findById(customerId).
                orElseThrow(() -> new RuntimeException("Customer not found"));
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(months);
        List<Transaction> transactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId, startDate, endDate);
        if (transactions.isEmpty()) {
            throw new CustomerNotFoundException(
                    "Customer not found with ID: " + customerId, customerId
            );
        }
        Map<String, MonthlyReward> rewardsMap = new LinkedHashMap<>();
        for (Transaction transaction : transactions) {
            String month = transaction.getTransactionDate().getMonth().toString() + " " + transaction.getTransactionDate().getYear();
            double amount = transaction.getAmount();
            int points = calculateRewardPoints(amount);
            rewardsMap.putIfAbsent(month, new MonthlyReward(month, 0, 0));
            MonthlyReward reward = rewardsMap.get(month);
            reward.totalAmount += amount;
            reward.rewardPoints += points;
        }

        List<MonthlyReward> monthlyRewards = new ArrayList<>(rewardsMap.values());
        int totalPoints = monthlyRewards.stream().mapToInt(r -> r.rewardPoints).sum();
        return new RewardsResponse(customerId, customer.getName(), monthlyRewards, totalPoints);
    }

    /*Methods to calculate rewards points */
    public int calculateRewardPoints(double amount) {
        if (amount <= 0) {
            throw new InvalidTransactionAmountException("Transaction amount must be greater than zero.");
        }
        int points = 0;
        if (amount > 100) {
            points += (amount - 100) * 2;
            amount = 100;
        }
        if (amount > 50) {
            points += (amount - 50);
        }
        return points;
    }

    /*  Fetch all customers */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
