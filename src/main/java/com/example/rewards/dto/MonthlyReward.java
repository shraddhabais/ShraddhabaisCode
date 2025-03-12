package com.example.rewards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyReward {
    public String month;
    public double totalAmount;
    public int rewardPoints;
}
