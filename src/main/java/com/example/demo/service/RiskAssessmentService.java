package com.example.demo.service;

import com.example.demo.entity.RiskAssessment;

public interface RiskAssessmentService {

    RiskAssessment assessRisk(Long userId);

    // REQUIRED BY TESTS
    RiskAssessment getByLoanRequestId(Long loanRequestId);
}
