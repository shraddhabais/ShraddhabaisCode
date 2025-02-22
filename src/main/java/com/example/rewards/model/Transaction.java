package com.example.rewards.model;


public class Transaction {
    private String customerId;
    private String customerName;
    private String transactionDate;
    private double amount;

    // Constructors, getters, and setters
    public Transaction(String customerId, String transactionDate, double amount, String customerName) {
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
