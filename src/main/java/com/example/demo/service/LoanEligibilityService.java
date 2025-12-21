package com.example.demo.service;

import com.example.demo.model.EligibilityResult;

public interface LoanEligibilityService {
    EligibilityResult evaluateEligibility(Long loanRequestId);
    EligibilityResult getResultByRequest(Long requestId);
}
