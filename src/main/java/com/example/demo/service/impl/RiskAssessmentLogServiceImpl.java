package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.LoanRequest;
import com.example.demo.model.RiskAssessment;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.service.RiskAssessmentLogicService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RiskAssessmentLogServiceImpl implements RiskAssessmentLogService {

    private final RiskAssessmentRepository repository;

    public RiskAssessmentLogServiceImpl(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskAssessment assessRisk(LoanRequest loanRequest) {

        if (loanRequest == null) {
            throw new BadRequestException("Loan request cannot be null");
        }

        RiskAssessment assessment = new RiskAssessment();
        assessment.setLoanRequest(loanRequest);

        if (loanRequest.getRequestedAmount() <= 500000) {
            assessment.setRiskLevel("LOW");
            assessment.setRiskScore(0.2);
        } else if (loanRequest.getRequestedAmount() <= 1000000) {
            assessment.setRiskLevel("MEDIUM");
            assessment.setRiskScore(0.5);
        } else {
            assessment.setRiskLevel("HIGH");
            assessment.setRiskScore(0.8);
        }

        assessment.setAssessedAt(new Timestamp(System.currentTimeMillis()));
        return repository.save(assessment);
    }

    @Override
    public RiskAssessment getRiskByLoan(LoanRequest loanRequest) {
        return repository.findByLoanRequest(loanRequest)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Risk assessment not found for loan")
                );
    }
}
