package com.example.rewards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RewardsResponse {
    public Long customerId;
    public String customerName;
    public List<MonthlyReward> transactions;
    public int totalRewardPoints;
}