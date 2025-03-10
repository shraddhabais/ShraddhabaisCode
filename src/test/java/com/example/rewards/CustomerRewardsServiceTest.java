
package com.example.rewards;

import com.example.rewards.service.CustomerRewardsService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerRewardsServiceTest {
    private final CustomerRewardsService customerRewardsService = new CustomerRewardsService();

    @Test
    public void testCalculateRewards() {
        assertEquals(91, customerRewardsService.calculateRewardPoints(120.50));
        assertEquals(25, customerRewardsService.calculateRewardPoints(75));
    }

}

