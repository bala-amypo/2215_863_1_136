package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class EligibilityResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private LoanRequest loanRequest;

    private Boolean isEligible;
    private Double maxEligibleAmount;
    private Double estimatedEmi;
    private String riskLevel;
    private String rejectionReason;

    private Timestamp calculatedAt = new Timestamp(System.currentTimeMillis());
}
