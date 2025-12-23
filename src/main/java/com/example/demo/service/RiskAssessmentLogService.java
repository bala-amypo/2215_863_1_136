package com.example.demo.service;

import com.example.demo.model.RiskAssessment;
import com.example.demo.model.LoanRequest;

public interface RiskAssessmentLogService {

    RiskAssessment assessRisk(LoanRequest loanRequest);

    RiskAssessment getRiskByLoan(LoanRequest loanRequest);
}
