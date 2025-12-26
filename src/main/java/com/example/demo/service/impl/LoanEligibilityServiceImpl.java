package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    private final EligibilityResultRepository eligibilityResultRepository;
    private final LoanRequestRepository loanRequestRepository;

    public LoanEligibilityServiceImpl(EligibilityResultRepository eligibilityResultRepository, 
                                    LoanRequestRepository loanRequestRepository) {
        this.eligibilityResultRepository = eligibilityResultRepository;
        this.loanRequestRepository = loanRequestRepository;
    }

    @Override
    public EligibilityResult evaluate(Long loanRequestId) {
        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(loanRequest);
        result.setIsEligible(true);
        result.setMaxEligibleAmount(loanRequest.getRequestedAmount());
        result.setEstimatedEmi(BigDecimal.valueOf(1000));
        result.setRiskLevel("LOW");

        return eligibilityResultRepository.save(result);
    }

    @Override
    public EligibilityResult getResult(Long loanRequestId) {
        return eligibilityResultRepository.findByLoanRequest_Id(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
    }
}
