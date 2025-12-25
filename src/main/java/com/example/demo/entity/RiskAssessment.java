package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "risk_assessments")
public class RiskAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Integer riskScore;

    private String riskLevel;   // LOW, MEDIUM, HIGH

    private Boolean eligible;

    // ✅ REQUIRED: No-args constructor (JPA + Tests)
    public RiskAssessment() {
    }

    // ✅ REQUIRED: All-args constructor (Tests use this)
    public RiskAssessment(Long id,
                          Long userId,
                          Integer riskScore,
                          String riskLevel,
                          Boolean eligible) {
        this.id = id;
        this.userId = userId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.eligible = eligible;
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Integer riskScore) {
        this.riskScore = riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Boolean getEligible() {
        return eligible;
    }

    public void setEligible(Boolean eligible) {
        this.eligible = eligible;
    }
}
