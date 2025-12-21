package com.example.demo.service;

import com.example.demo.model.EligibilityResult;
import com.example.demo.model.FinancialProfile;
import com.example.demo.model.LoanRequest;

public interface LoanEligibilityService {
    EligibilityResult evaluateLoanEligibility(FinancialProfile profile, LoanRequest loan);
    EligibilityResult getEligibilityResult(LoanRequest loan);
}
