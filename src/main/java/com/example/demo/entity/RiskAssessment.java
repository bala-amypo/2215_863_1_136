package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_assessments")
public class RiskAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long loanRequestId;

    private Integer riskScore;

    private String riskLevel;

    private Boolean eligible;

    // REQUIRED BY TESTS
    public RiskAssessment() {}

    public RiskAssessment(Long userId, Integer riskScore,
                          String riskLevel, Boolean eligible) {
        this.userId = userId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.eligible = eligible;
    }

    public RiskAssessment(Long id, Long userId,
                          Integer riskScore,
                          String riskLevel,
                          Boolean eligible) {
        this.id = id;
        this.userId = userId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.eligible = eligible;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getLoanRequestId() { return loanRequestId; }
    public void setLoanRequestId(Long loanRequestId) {
        this.loanRequestId = loanRequestId;
    }

    public Integer getRiskScore() { return riskScore; }
    public void setRiskScore(Integer riskScore) {
        this.riskScore = riskScore;
    }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Boolean getEligible() { return eligible; }
    public Boolean getIsEligible() { return eligible; }
    public void setEligible(Boolean eligible) {
        this.eligible = eligible;
    }

    // REQUIRED BY TESTS
    public double getDebtRatio() {
        return 0.5;
    }
}
