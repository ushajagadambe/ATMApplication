package com.test.techApplication.ATMStatusApplication.Entitty;


import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity representing a transaction at the ATM.
 */
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private String customerId;  // ID of the customer making the transaction

    @Column(name = "type", nullable = false)
    private String type;  // Transaction type (e.g., Deposit, Withdrawal, Balance Info)

    @Column(name = "amount", nullable = false)
    private Double amount;  // Amount involved in the transaction

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;  // The timestamp when the transaction occurred

    public Transaction() {
    }

    public Transaction(String customerId, String type, Double amount, LocalDateTime timestamp) {
        this.customerId = customerId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transaction(String key, int size, double sum) {
    }

    // Getters and Setters



    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

