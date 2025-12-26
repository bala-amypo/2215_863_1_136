// src/main/java/com/example/demo/entity/FinancialProfile.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
        name = "financial_profiles",
        uniqueConstraints = @UniqueConstraint(columnNames = "user_id")
)
public class FinancialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double monthlyIncome;
    private Double monthlyExpenses;
    private Double existingLoanEmi;
    private Integer creditScore;
    private Double savingsBalance;

    private Instant lastUpdatedAt;

    @PrePersist
    @PreUpdate
    public void prePersistOrUpdate() {
        // t29_entity_prepersist_timestamps expects this to be set when createOrUpdate is called
        lastUpdatedAt = Instant.now();
    }

    // getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Double getMonthlyIncome() { return monthlyIncome; }

    public void setMonthlyIncome(Double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

    public Double getMonthlyExpenses() { return monthlyExpenses; }

    public void setMonthlyExpenses(Double monthlyExpenses) { this.monthlyExpenses = monthlyExpenses; }

    public Double getExistingLoanEmi() { return existingLoanEmi; }

    public void setExistingLoanEmi(Double existingLoanEmi) { this.existingLoanEmi = existingLoanEmi; }

    public Integer getCreditScore() { return creditScore; }

    public void setCreditScore(Integer creditScore) { this.creditScore = creditScore; }

    public Double getSavingsBalance() { return savingsBalance; }

    public void setSavingsBalance(Double savingsBalance) { this.savingsBalance = savingsBalance; }

    public Instant getLastUpdatedAt() { return lastUpdatedAt; }

    public void setLastUpdatedAt(Instant lastUpdatedAt) { this.lastUpdatedAt = lastUpdatedAt; }
}