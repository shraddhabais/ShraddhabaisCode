package com.example.rewards.dto;

import java.util.List;

public class RewardsResponse {
    public Long customerId;
    public String customerName;
    public List<MonthlyReward> transactions;
    public int totalRewardPoints;

    public RewardsResponse(Long customerId, String customerName, List<MonthlyReward> transactions, int totalRewardPoints) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.transactions = transactions;
        this.totalRewardPoints = totalRewardPoints;
    }
}
