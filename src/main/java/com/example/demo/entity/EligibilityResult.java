// src/main/java/com/example/demo/entity/EligibilityResult.java
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eligibility_results")
public class EligibilityResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "loan_request_id")
    private LoanRequest loanRequest;

    private Double maxEligibleAmount;

    // getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public LoanRequest getLoanRequest() { return loanRequest; }

    public void setLoanRequest(LoanRequest loanRequest) { this.loanRequest = loanRequest; }

    public Double getMaxEligibleAmount() { return maxEligibleAmount; }

    public void setMaxEligibleAmount(Double maxEligibleAmount) { this.maxEligibleAmount = maxEligibleAmount; }
}