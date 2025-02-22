package com.example.rewards;

import com.example.rewards.service.CustomerRewardsService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerRewardsServiceTest {
    private final CustomerRewardsService rewardPointsService = new CustomerRewardsService();

    @Test
    public void testCalculateRewards() {
        assertEquals(90, rewardPointsService.calculateRewardPoints(120)); // 2x20 + 1x50 = 90
        assertEquals(50, rewardPointsService.calculateRewardPoints(75));  // 1x25 + 1x50 = 50
        assertEquals(200, rewardPointsService.calculateRewardPoints(150)); // 2x50 + 1x50 = 200
        assertEquals(45, rewardPointsService.calculateRewardPoints(95)); // 2x45 + 1x50 = 45
    }

}
