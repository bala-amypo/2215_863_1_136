package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(loanRequest);
        result.setIsEligible(true);
        result.setMaxEligibleAmount(loanRequest.getRequestedAmount());
        result.setEstimatedEmi(1000.0);
        result.setRiskLevel("LOW");
        result.setCalculatedAt(new Timestamp(System.currentTimeMillis()));

        return eligibilityResultRepository.save(result);
    }

    @Override
    public EligibilityResult getResultByRequest(Long requestId) {
        return eligibilityResultRepository.findByLoanRequestId(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found"));
    }
}
// src/main/java/com/example/demo/service/impl/EligibilityServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;
    private final EligibilityResultRepository eligibilityResultRepository;

    public EligibilityServiceImpl(LoanRequestRepository loanRequestRepository,
                                  FinancialProfileRepository financialProfileRepository,
                                  EligibilityResultRepository eligibilityResultRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
        this.eligibilityResultRepository = eligibilityResultRepository;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        LoanRequest request = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("LoanRequest not found"));

        if (eligibilityResultRepository.findByLoanRequestId(loanRequestId).isPresent()) {
            throw new BadRequestException("Eligibility already evaluated");
        }

        Long userId = request.getUser().getId();
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double disposableIncome = profile.getMonthlyIncome() - profile.getMonthlyExpenses()
                - (profile.getExistingLoanEmi() != null ? profile.getExistingLoanEmi() : 0.0);
        if (disposableIncome < 0) disposableIncome = 0;
        double maxEligible = disposableIncome * 10; // simple heuristic

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(request);
        result.setMaxEligibleAmount(maxEligible);
        return eligibilityResultRepository.save(result);
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId) {
        return eligibilityResultRepository.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Eligibility not found"));
    }
}