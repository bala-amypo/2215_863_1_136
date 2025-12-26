package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_assessment_logs")
public class RiskAssessmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long loanRequestId;

    @Column
    private BigDecimal dtiRatio;

    @Column
    private String creditCheckStatus;

    @Column(nullable = false)
    private Timestamp timestamp;

    public RiskAssessmentLog() {}

    public RiskAssessmentLog(Long loanRequestId, BigDecimal dtiRatio, String creditCheckStatus, 
                           Timestamp timestamp) {
        this.loanRequestId = loanRequestId;
        this.dtiRatio = dtiRatio;
        this.creditCheckStatus = creditCheckStatus;
        this.timestamp = timestamp;
    }

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

    public BigDecimal getDtiRatio() {
        return dtiRatio;
    }

    public void setDtiRatio(BigDecimal dtiRatio) {
        this.dtiRatio = dtiRatio;
    }

    public String getCreditCheckStatus() {
        return creditCheckStatus;
    }

    public void setCreditCheckStatus(String creditCheckStatus) {
        this.creditCheckStatus = creditCheckStatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}