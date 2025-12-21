package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Risk Assessment Log model")
public class RiskAssessmentLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanRequestId;
    private Double dtiRatio;
    private String creditCheckStatus;
    private Timestamp timestamp;

    public RiskAssessmentLog() {}
    public RiskAssessmentLog(Long id, Long loanRequestId, Double dtiRatio, String creditCheckStatus, Timestamp timestamp) {
        this.id = id; this.loanRequestId = loanRequestId; this.dtiRatio = dtiRatio; this.creditCheckStatus = creditCheckStatus; this.timestamp = timestamp;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getLoanRequestId() { return loanRequestId; }
    public void setLoanRequestId(Long loanRequestId) { this.loanRequestId = loanRequestId; }
    public Double getDtiRatio() { return dtiRatio; }
    public void setDtiRatio(Double dtiRatio) { this.dtiRatio = dtiRatio; }
    public String getCreditCheckStatus() { return creditCheckStatus; }
    public void setCreditCheckStatus(String creditCheckStatus) { this.creditCheckStatus = creditCheckStatus; }
    public Timestamp getTimestamp() { return timestamp; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
}
