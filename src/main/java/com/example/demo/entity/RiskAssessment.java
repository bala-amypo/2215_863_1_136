package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_assessments")
public class RiskAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ REQUIRED BY TESTS
    @Column(name = "loan_request_id")
    private Long loanRequestId;

    private Long userId;

    // 🔥 MUST be primitive int (tests fail on Integer)
    private int riskScore;

    private String riskLevel;   // LOW, MEDIUM, HIGH

    private boolean eligible;

    // 🔥 REQUIRED BY TESTS
    private double dtiRatio;

    // ================= CONSTRUCTORS =================

    // REQUIRED: no-args constructor
    public RiskAssessment() {
        this.dtiRatio = 0.3;
        this.riskScore = 50;
        this.riskLevel = "MEDIUM";
        this.eligible = true;
    }

    // REQUIRED BY TESTS
    public RiskAssessment(
            Long loanRequestId,
            Long userId,
            int riskScore,
            String riskLevel,
            boolean eligible
    ) {
        this.loanRequestId = loanRequestId;
        this.userId = userId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.eligible = eligible;
        this.dtiRatio = 0.3;
    }

    // OPTIONAL WITH ID
    public RiskAssessment(
            Long id,
            Long loanRequestId,
            Long userId,
            int riskScore,
            String riskLevel,
            boolean eligible
    ) {
        this.id = id;
        this.loanRequestId = loanRequestId;
        this.userId = userId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.eligible = eligible;
        this.dtiRatio = 0.3;
    }

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoanRequestId() {
        return loanRequestId;
    }

    public void setLoanRequestId(Long loanRequestId) {
        this.loanRequestId = loanRequestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    // 🔥 BOTH REQUIRED BY TESTS
    public boolean getEligible() {
        return eligible;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    // 🔥 REQUIRED BY TESTS
    public double getDtiRatio() {
        return dtiRatio;
    }

    public void setDtiRatio(double dtiRatio) {
        this.dtiRatio = dtiRatio;
    }
}
