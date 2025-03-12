package com.example.rewards;

import com.example.rewards.controller.CustomerRewardsController;
import com.example.rewards.dto.MonthlyReward;
import com.example.rewards.dto.RewardsResponse;
import com.example.rewards.model.Customer;
import com.example.rewards.service.CustomerRewardsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerRewardsControllerTest {
    @Mock
    private CustomerRewardsService customerRewardsService;

    @InjectMocks
    private CustomerRewardsController customerRewardsController;

    private RewardsResponse mockRewardsResponse;
    private List<Customer> mockCustomers;

    @BeforeEach
    void setUp() {

        List<MonthlyReward> monthlyRewards = Arrays.asList(
                new MonthlyReward("March", 500.00, 120),
                new MonthlyReward("February", 300.00, 75),
                new MonthlyReward("January", 250.00, 60)
        );

        mockRewardsResponse = new RewardsResponse(
                1L,
                "Jonny",
                monthlyRewards,
                255
        );

        // Mocking Customer List
        mockCustomers = Arrays.asList(
                new Customer(1L, "Jonny"),
                new Customer(2L, "Ronny")
        );
    }

    @Test
    void testGetRewards() {
        when(customerRewardsService.calculateRewards(1L, 3)).thenReturn(mockRewardsResponse);

        ResponseEntity<RewardsResponse> response = customerRewardsController.getRewards(1L, 3);

        assertNotNull(response);
        assertEquals("Jonny", response.getBody().customerName);
        assertEquals(255, response.getBody().totalRewardPoints);
        assertEquals(3, response.getBody().transactions.size());


        MonthlyReward marchReward = response.getBody().transactions.get(0);
        assertEquals("March", marchReward.month);
        assertEquals(500.00, marchReward.totalAmount, 0.01);
        assertEquals(120, marchReward.rewardPoints);
    }

    @Test
    void testGetAllCustomers() {
        when(customerRewardsService.getAllCustomers()).thenReturn(mockCustomers);
        ResponseEntity<List<Customer>> response = customerRewardsController.getAllCustomers();
        assertNotNull(response);
        assertEquals("Ronny", response.getBody().get(1).getName());
    }


}

