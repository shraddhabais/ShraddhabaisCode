package com.example.rewards.dto;

public class MonthlyReward {
    public String month;
    public double totalAmount;
    public int rewardPoints;

    public MonthlyReward(String month, double totalAmount, int rewardPoints) {
        this.month = month;
        this.totalAmount = totalAmount;
        this.rewardPoints = rewardPoints;
    }
}
