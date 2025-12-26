package com.example.demo.service;

import com.example.demo.entity.RiskAssessment;

public interface EligibilityService {

    // REQUIRED BY TESTS
    boolean isEligible(int creditScore, double dtiRatio);

    // REQUIRED BY TESTS
    boolean evaluateEligibility(long loanRequestId);

    // REQUIRED BY TESTS
    RiskAssessment getByLoanRequestId(long loanRequestId);
}
