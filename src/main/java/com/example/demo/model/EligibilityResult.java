package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class EligibilityResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private LoanRequest loanRequest;

    private Boolean isEligible;
    private Double maxEligibleAmount;
    private Double estimatedEmi;
    private String riskLevel; // LOW / MEDIUM / HIGH
    private String rejectionReason;
    private Timestamp calculatedAt;
}
