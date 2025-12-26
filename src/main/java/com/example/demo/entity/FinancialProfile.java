package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "financial_profile")
public class FinancialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private Double monthlyIncome;
    private Double monthlyExpenses;
    private Double existingLoanEmi;
    private Integer creditScore;
    private Double savingsBalance;
    private Timestamp lastUpdatedAt;

    public FinancialProfile() {
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    public FinancialProfile(User user,
                            Double monthlyIncome,
                            Double monthlyExpenses,
                            Double existingLoanEmi,
                            Integer creditScore,
                            Double savingsBalance) {
        this.user = user;
        this.monthlyIncome = monthlyIncome;
        this.monthlyExpenses = monthlyExpenses;
        this.existingLoanEmi = existingLoanEmi;
        this.creditScore = creditScore;
        this.savingsBalance = savingsBalance;
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Double getMonthlyIncome() { return monthlyIncome; }
    public Double getMonthlyExpenses() { return monthlyExpenses; }

    // ✅ REQUIRED BY TESTS
    public Double getIncome() { return monthlyIncome; }
    public Double getExpenses() { return monthlyExpenses; }

    public Double getExistingLoanEmi() { return existingLoanEmi; }
    public Integer getCreditScore() { return creditScore; }
    public Double getSavingsBalance() { return savingsBalance; }

    public Timestamp getLastUpdatedAt() { return lastUpdatedAt; }
}
