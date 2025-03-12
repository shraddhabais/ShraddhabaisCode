
package com.example.rewards;

import com.example.rewards.exception.CustomerNotFoundException;
import com.example.rewards.exception.InvalidTransactionAmountException;
import com.example.rewards.model.Customer;
import com.example.rewards.model.Transaction;
import com.example.rewards.repository.CustomerRepository;
import com.example.rewards.repository.TransactionRepository;
import com.example.rewards.dto.RewardsResponse;
import com.example.rewards.service.CustomerRewardsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerRewardsServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerRewardsService customerRewardsService;

    private Customer customer;
    private List<Transaction> transactions;

    @BeforeEach
    void setUp() {
        customer = new Customer(1L, "Jonny");
        transactions = Arrays.asList(
                new Transaction(1L, 1L, 120.0, LocalDate.now().minusDays(10)),
                new Transaction(2L, 1L, 75.0, LocalDate.now().minusDays(20))
        );
    }

    @Test
    void testCalculateRewards_Positive() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(transactionRepository.findByCustomerIdAndTransactionDateBetween(eq(1L), any(), any()))
                .thenReturn(transactions);

        RewardsResponse response = customerRewardsService.calculateRewards(1L, 3);
        assertNotNull(response);
        assertEquals(1L, response.getCustomerId());
        assertEquals("Jonny", response.getCustomerName());
        assertEquals(90 + 25, response.getTotalRewardPoints());
    }

    @Test
    void testCalculateRewards_CustomerNotFound() {
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> customerRewardsService.calculateRewards(1L, 3));
    }

    @Test
    void testCalculateRewards_NoTransactions() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(transactionRepository.findByCustomerIdAndTransactionDateBetween(eq(1L), any(), any()))
                .thenReturn(List.of());

        assertThrows(CustomerNotFoundException.class, () -> customerRewardsService.calculateRewards(1L, 3));
    }

    @Test
    void testCalculateRewardPoints_NegativeAmount() {
        assertThrows(InvalidTransactionAmountException.class, () -> customerRewardsService.calculateRewardPoints(-10));
    }

    @Test
    void testCalculateRewardPoints_ZeroAmount() {
        assertThrows(InvalidTransactionAmountException.class, () -> customerRewardsService.calculateRewardPoints(0));
    }

}

