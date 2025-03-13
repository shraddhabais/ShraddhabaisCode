package com.example.rewards;

import com.example.rewards.controller.CustomerRewardsController;
import com.example.rewards.dto.MonthlyReward;
import com.example.rewards.dto.RewardsResponse;
import com.example.rewards.model.Customer;
import com.example.rewards.service.CustomerRewardsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRewardsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerRewardsService customerRewardsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetRewards() throws Exception {
        Long customerId = 1L;
        int months = 3;
        List<MonthlyReward> monthlyRewards = Arrays.asList(
                new MonthlyReward("FEBRUARY 2025", 120.0, 90),
                new MonthlyReward("MARCH 2025", 80.0, 30),
                new MonthlyReward("APRIL 2025", 200.0, 250)
        );
        RewardsResponse response = new RewardsResponse(customerId, "Jonny", monthlyRewards, 370);

        when(customerRewardsService.calculateRewards(customerId, months)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/rewards")
                        .param("customerId", customerId.toString())
                        .param("months", String.valueOf(months)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value(customerId))
                .andExpect(jsonPath("$.customerName").value("Jonny"))
                .andExpect(jsonPath("$.transactions[0].month").value("FEBRUARY 2025"))
                .andExpect(jsonPath("$.transactions[0].totalAmount").value(100.0))
                .andExpect(jsonPath("$.transactions[0].rewardPoints").value(50))
                .andExpect(jsonPath("$.totalRewardPoints").value(300));
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        List<Customer> customers = Arrays.asList(new Customer(1L, "Jonny"), new Customer(2L, "Ronny"));
        when(customerRewardsService.getAllCustomers()).thenReturn(customers);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/rewards/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Jonny"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Ronny"));
    }

}

