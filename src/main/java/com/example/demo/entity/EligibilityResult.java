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

    // ✅ 1. Default constructor (REQUIRED by JPA)
    public EligibilityResult() {
        this.calculatedAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 2. Parameterized constructor (used in services & tests)
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

    // ✅ 3. ID (getter + setter REQUIRED for tests)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ✅ 4. Loan Request
    public LoanRequest getLoanRequest() {
        return loanRequest;
    }

    public void setLoanRequest(LoanRequest loanRequest) {
        this.loanRequest = loanRequest;
    }

    // ✅ 5. Eligibility Flag
    public Boolean getIsEligible() {
        return isEligible;
    }

    public void setIsEligible(Boolean eligible) {
        this.isEligible = eligible;
    }

    // ✅ 6. Max Eligible Amount
    public Double getMaxEligibleAmount() {
        return maxEligibleAmount;
    }

    public void setMaxEligibleAmount(Double maxEligibleAmount) {
        this.maxEligibleAmount = maxEligibleAmount;
    }

    // ✅ 7. Estimated EMI
    public Double getEstimatedEmi() {
        return estimatedEmi;
    }

    public void setEstimatedEmi(Double estimatedEmi) {
        this.estimatedEmi = estimatedEmi;
    }

    // ✅ 8. Risk Level
    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    // ✅ 9. Rejection Reason
    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    // ✅ 10. Calculated Timestamp
    public Timestamp getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(Timestamp calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
}
