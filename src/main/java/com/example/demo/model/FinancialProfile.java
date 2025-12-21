package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class FinancialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private Double monthlyIncome;
    private Double monthlyExpenses;
    private Double existingLoanEmi;
    private Integer creditScore;
    private Double savingsBalance;
    private Timestamp lastUpdatedAt;
}
