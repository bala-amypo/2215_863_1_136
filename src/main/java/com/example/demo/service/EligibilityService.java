package com.example.demo.service;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.RiskAssessment;

public interface EligibilityService {

    // ================= REQUIRED BY TESTS =================

    boolean isEligible(int creditScore, double dtiRatio);

    boolean evaluateEligibility(long loanRequestId);

    RiskAssessment getByLoanRequestId(long loanRequestId);

    // ================= MISSING METHODS (CAUSE OF ERROR) =================

    // 🔥 Tests expect THIS overload
    EligibilityResult evaluateEligibility(Long loanRequestId);

    // 🔥 Tests expect THIS overload as well
    EligibilityResult evaluateEligibility(Long loanRequestId, Object ignored);
}
