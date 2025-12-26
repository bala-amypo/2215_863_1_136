// src/main/java/com/example/demo/service/EligibilityService.java
package com.example.demo.service;

import com.example.demo.entity.EligibilityResult;

public interface EligibilityService {
    EligibilityResult evaluateEligibility(Long loanRequestId);
    EligibilityResult getByLoanRequestId(Long loanRequestId);
}