package com.example.rewards.service;

import com.example.rewards.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class CustomerRewardsService {

    //Methods to calculate rewards based on customer transactions
    public Map<String, Integer> calculateRewards(List<Transaction> transactions) {
        Map<String, Integer> customerRewards = new HashMap<>();

        for (Transaction transaction : transactions) {
            int points = calculateRewardPoints(transaction.getAmount());
            customerRewards.put(transaction.getCustomerId(),
                    customerRewards.getOrDefault(transaction.getCustomerId(), 0) + points);
        }
        return customerRewards;
    }

    public int calculateRewardPoints(double amount) {
        int points = 0;

        // Points for amount over $100 (2 points per $1)
        if (amount > 100) {
            points += (amount - 100) * 2;
            amount = 100;
        }

        // Points for amount between $50 and $100 (1 point per $1)
        if (amount > 50) {
            points += (amount - 50);
        }

        return points;
    }

}
