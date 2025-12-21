package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository profileRepo;
    private final EligibilityResultRepository resultRepo;

    public LoanEligibilityServiceImpl(LoanRequestRepository loanRepo,
                                      FinancialProfileRepository profileRepo,
                                      EligibilityResultRepository resultRepo) {
        this.loanRepo = loanRepo;
        this.profileRepo = profileRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        LoanRequest loan = loanRepo.findById(loanRequestId)
                .orElseThrow(() -> new RuntimeException("Loan request not found"));

        FinancialProfile profile = profileRepo.findByUserId(loan.getUser().getId());
        if (profile == null) {
            throw new RuntimeException("Financial profile not found");
        }

        double dti = (profile.getExistingLoanEmi()) / profile.getMonthlyIncome();
        String riskLevel;
        if (dti < 0.2) riskLevel = "LOW";
        else if (dti < 0.35) riskLevel = "MEDIUM";
        else riskLevel = "HIGH";

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(loan);
        result.setIsEligible(dti < 0.35 && profile.getCreditScore() >= 300);
        result.setMaxEligibleAmount(loan.getRequestedAmount() * (1 - dti));
        result.setEstimatedEmi(loan.getRequestedAmount() / loan.getTenureMonths());
        result.setRiskLevel(riskLevel);
        result.setCalculatedAt(new java.sql.Timestamp(System.currentTimeMillis()));

        return resultRepo.save(result);
    }

    @Override
    public EligibilityResult getResultByRequest(Long loanRequestId) {
        EligibilityResult result = resultRepo.findByLoanRequestId(loanRequestId);
        if (result == null) {
            throw new RuntimeException("Eligibility result not found");
        }
        return result;
    }
}
