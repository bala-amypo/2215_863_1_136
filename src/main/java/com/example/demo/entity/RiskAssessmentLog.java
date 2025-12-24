package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "risk_assessment_log")
public class RiskAssessmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanRequestId;
    private Double dtiRatio;
    private String creditCheckStatus;

    private Timestamp timestamp;

    // ✅ 1. Default constructor (REQUIRED by JPA)
    public RiskAssessmentLog() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 2. Parameterized constructor
    public RiskAssessmentLog(Long loanRequestId,
                             Double dtiRatio,
                             String creditCheckStatus) {
        this.loanRequestId = loanRequestId;
        this.dtiRatio = dtiRatio;
        this.creditCheckStatus = creditCheckStatus;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 3. ID (getter + setter required for tests)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ✅ 4. Loan Request ID
    public Long getLoanRequestId() {
        return loanRequestId;
    }

    public void setLoanRequestId(Long loanRequestId) {
        this.loanRequestId = loanRequestId;
    }

    // ✅ 5. DTI Ratio
    public Double getDtiRatio() {
        return dtiRatio;
    }

    public void setDtiRatio(Double dtiRatio) {
        this.dtiRatio = dtiRatio;
    }

    // ✅ 6. Credit Check Status
    public String getCreditCheckStatus() {
        return creditCheckStatus;
    }

    public void setCreditCheckStatus(String creditCheckStatus) {
        this.creditCheckStatus = creditCheckStatus;
    }

    // ✅ 7. Timestamp
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
