package com.example.rewards.controller;

import com.example.rewards.dto.RewardsResponse;
import com.example.rewards.model.Customer;
import com.example.rewards.service.CustomerRewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class CustomerRewardsController {
    @Autowired
    CustomerRewardsService customerRewardsService;

    /* Calculates reward points for a given customer over a specified number of months.
      @param customerId The customer ID
    @param months The number of past months to consider (default: 3)
     * @return RewardsResponse containing monthly and total reward points
     */
    @GetMapping()
    public ResponseEntity<RewardsResponse> getRewards(@RequestParam Long customerId, @RequestParam(defaultValue = "3") int months) {
        RewardsResponse rewards = customerRewardsService.calculateRewards(customerId, months);
        return ResponseEntity.ok(rewards);
    }

    /*Get all customers*/
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRewardsService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
}
