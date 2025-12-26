package com.example.demo.service;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.RiskAssessment;

public interface EligibilityService {

    boolean isEligible(int creditScore, double dtiRatio);

    boolean evaluateEligibility(long loanRequestId);

    RiskAssessment getByLoanRequestId(long loanRequestId);

    // 🔥 REQUIRED BY TESTS
    EligibilityResult evaluateEligibility(Long loanRequestId);
}
