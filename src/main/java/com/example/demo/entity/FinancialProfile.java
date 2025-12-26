package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "financial_profiles")
public class FinancialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private BigDecimal monthlyIncome;

    @Column
    private BigDecimal monthlyExpenses;

    @Column
    private BigDecimal existingLoanEmi;

    @Column
    private Integer creditScore;

    @Column
    private BigDecimal savingsBalance;

    @Column
    private Timestamp lastUpdatedAt;

    public FinancialProfile() {}

    public FinancialProfile(User user, BigDecimal monthlyIncome, BigDecimal monthlyExpenses, 
                          BigDecimal existingLoanEmi, Integer creditScore, BigDecimal savingsBalance, 
                          Timestamp lastUpdatedAt) {
        this.user = user;
        this.monthlyIncome = monthlyIncome;
        this.monthlyExpenses = monthlyExpenses;
        this.existingLoanEmi = existingLoanEmi;
        this.creditScore = creditScore;
        this.savingsBalance = savingsBalance;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ... all getters and setters (same as before)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public BigDecimal getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(BigDecimal monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public BigDecimal getExistingLoanEmi() {
        return existingLoanEmi;
    }

    public void setExistingLoanEmi(BigDecimal existingLoanEmi) {
        this.existingLoanEmi = existingLoanEmi;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public BigDecimal getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(BigDecimal savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
