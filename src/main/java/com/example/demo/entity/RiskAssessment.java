package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_assessments")
public class RiskAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanRequestId;
    private Long userId;
    private Integer riskScore;
    private String riskLevel;
    private Boolean eligible;
    private Double dtiRatio;

    public RiskAssessment() {
        this.dtiRatio = 0.3;
    }

    public RiskAssessment(Long loanRequestId,
                          Long userId,
                          Integer riskScore,
                          String riskLevel,
                          Boolean eligible) {
        this.loanRequestId = loanRequestId;
        this.userId = userId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.eligible = eligible;
        this.dtiRatio = 0.3;
    }

    public RiskAssessment(Long id,
                          Long loanRequestId,
                          Long userId,
                          Integer riskScore,
                          String riskLevel,
                          Boolean eligible) {
        this.id = id;
        this.loanRequestId = loanRequestId;
        this.userId = userId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.eligible = eligible;
        this.dtiRatio = 0.3;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getLoanRequestId() { return loanRequestId; }
    public void setLoanRequestId(Long loanRequestId) { this.loanRequestId = loanRequestId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Integer getRiskScore() { return riskScore; }
    public void setRiskScore(Integer riskScore) { this.riskScore = riskScore; }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    public Boolean getEligible() { return eligible; }
    public Boolean getIsEligible() { return eligible; }

    // ✅ REQUIRED BY TESTS
    public boolean isEligible() {
        return Boolean.TRUE.equals(eligible);
    }

    public void setEligible(Boolean eligible) { this.eligible = eligible; }

    public Double getDtiRatio() { return dtiRatio; }
    public void setDtiRatio(Double dtiRatio) { this.dtiRatio = dtiRatio; }
}
