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

    // ✅ 1. Default constructor (REQUIRED by JPA)
    public FinancialProfile() {
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 2. Parameterized constructor (used in services & tests)
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

    // ✅ 3. ID (getter + setter REQUIRED for tests)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ✅ 4. User
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // ✅ 5. Monthly Income
    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 6. Monthly Expenses
    public Double getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(Double monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 7. Existing Loan EMI
    public Double getExistingLoanEmi() {
        return existingLoanEmi;
    }

    public void setExistingLoanEmi(Double existingLoanEmi) {
        this.existingLoanEmi = existingLoanEmi;
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 8. Credit Score
    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 9. Savings Balance
    public Double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(Double savingsBalance) {
        this.savingsBalance = savingsBalance;
        this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 10. Last Updated Timestamp
    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
