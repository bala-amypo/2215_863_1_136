package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    private final EligibilityResultRepository repository;

    public LoanEligibilityServiceImpl(EligibilityResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        return repository.findByLoanRequest_Id(loanRequestId)
                .orElse(null);
    }

    @Override
    public EligibilityResult getResultByRequest(Long requestId) {
        return repository.findByLoanRequest_Id(requestId)
                .orElse(null);
    }
}
