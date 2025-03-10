package com.example.rewards.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)

    private String name;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
