package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "eligibility_result")
public class EligibilityResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "loan_request_id", unique = true)
    private LoanRequest loanRequest;

    private Boolean isEligible;
    private Double maxEligibleAmount;
    private Double estimatedEmi;
    private String riskLevel;
    private String rejectionReason;
    private Timestamp calculatedAt;

    public EligibilityResult() {
        this.calculatedAt = new Timestamp(System.currentTimeMillis());
    }

    public EligibilityResult(LoanRequest loanRequest,
                             Boolean isEligible,
                             Double maxEligibleAmount,
                             Double estimatedEmi,
                             String riskLevel,
                             String rejectionReason) {
        this.loanRequest = loanRequest;
        this.isEligible = isEligible;
        this.maxEligibleAmount = maxEligibleAmount;
        this.estimatedEmi = estimatedEmi;
        this.riskLevel = riskLevel;
        this.rejectionReason = rejectionReason;
        this.calculatedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() { return id; }

    public LoanRequest getLoanRequest() { return loanRequest; }

    public Boolean getIsEligible() { return isEligible; }

    // ✅ REQUIRED BY TESTS
    public boolean isEligible() {
        return Boolean.TRUE.equals(isEligible);
    }

    public Double getMaxEligibleAmount() { return maxEligibleAmount; }
    public Double getEstimatedEmi() { return estimatedEmi; }
    public String getRiskLevel() { return riskLevel; }
    public String getRejectionReason() { return rejectionReason; }
    public Timestamp getCalculatedAt() { return calculatedAt; }
}
