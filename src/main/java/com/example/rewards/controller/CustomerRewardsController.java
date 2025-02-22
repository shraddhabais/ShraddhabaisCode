package com.example.rewards.controller;

import com.example.rewards.model.Transaction;
import com.example.rewards.service.CustomerRewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rewards")
public class CustomerRewardsController {

    @Autowired
    private CustomerRewardsService rewardsService;

    @PostMapping("/calculateRewards")
    public Map<String, Integer> calculateRewards(@RequestBody List<Transaction> transactions) {
        return rewardsService.calculateRewards(transactions);
    }
}
