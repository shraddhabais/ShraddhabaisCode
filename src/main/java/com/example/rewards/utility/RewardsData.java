package com.example.rewards.utility;

import com.example.rewards.model.Transaction;

import java.util.List;

public class RewardsData {
    public static List<Transaction> getExampleTransactions() {
        return List.of(
                new Transaction("01", "2025-02-15", 120, "Shraddha"),
                new Transaction("02", "2025-02-16", 75, "Shivani"),
                new Transaction("03", "2025-02-20", 150, "Puja"),
                new Transaction("04", "2025-02-21", 95, "Shiva"),
                new Transaction("05", "2025-02-19", 80, "Ronit")
        );
    }
}
