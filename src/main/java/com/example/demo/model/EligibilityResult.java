package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Schema(description = "Eligibility Result model")
public class EligibilityResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "loan_request_id", nullable = false)
    private LoanRequest loanRequest;

    private Boolean isEligible;
    private Double maxEligibleAmount;
    private Double estimatedEmi;
    private String riskLevel;
    private String rejectionReason;

    @CreationTimestamp
    private Timestamp calculatedAt;

    public EligibilityResult() {}

    // getters & setters (same as yours)
}
