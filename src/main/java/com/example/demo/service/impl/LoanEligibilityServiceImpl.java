package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;
    private final EligibilityResultRepository eligibilityResultRepository;

    public LoanEligibilityServiceImpl(
            LoanRequestRepository loanRequestRepository,
            FinancialProfileRepository financialProfileRepository,
            EligibilityResultRepository eligibilityResultRepository) {

        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
        this.eligibilityResultRepository = eligibilityResultRepository;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {

        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        FinancialProfile profile = financialProfileRepository
                .findByUserId(loanRequest.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        double dti = (profile.getMonthlyExpenses() + profile.getExistingLoanEmi())
                / profile.getMonthlyIncome();

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(loanRequest);
        result.setIsEligible(dti < 0.6 && profile.getCreditScore() >= 600);
        result.setRiskLevel(dti > 0.5 ? "HIGH" : "LOW");
        result.setMaxEligibleAmount(profile.getMonthlyIncome() * 10);

        return eligibilityResultRepository.save(result);
    }

    @Override
    public EligibilityResult getResultByRequest(Long requestId) {
        return eligibilityResultRepository.findByLoanRequestId(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
