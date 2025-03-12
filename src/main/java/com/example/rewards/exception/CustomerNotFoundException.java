package com.example.rewards.exception;

import java.time.LocalDateTime;

public class CustomerNotFoundException extends RuntimeException {
    private final Long customerId;
    private final LocalDateTime timestamp;

    public CustomerNotFoundException(String message, Long customerId) {
        super(message);
        this.customerId = customerId;
        this.timestamp = LocalDateTime.now(); // Capture the time of the exception
    }

    public Long getCustomerId() {
        return customerId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
