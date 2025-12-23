package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.EligibilityResult;
import com.example.demo.model.FinancialProfile;
import com.example.demo.model.LoanRequest;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    private final EligibilityResultRepository repository;

    public LoanEligibilityServiceImpl(EligibilityResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public EligibilityResult evaluateLoanEligibility(FinancialProfile profile, LoanRequest loan) {
        if (profile == null) {
            throw new ResourceNotFoundException("Financial profile not found for the user");
        }
        if (loan == null) {
            throw new BadRequestException("Loan request cannot be null");
        }

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(loan);

        double dti = (profile.getExistingLoanEmi() + loan.getRequestedAmount() / loan.getTenureMonths())
                / profile.getMonthlyIncome();

        if (profile.getCreditScore() >= 700 && dti < 0.4) {
            result.setIsEligible(true);
            result.setMaxEligibleAmount(loan.getRequestedAmount());
            result.setEstimatedEmi(loan.getRequestedAmount() / loan.getTenureMonths());
            result.setRiskLevel("Low");
        } else {
            result.setIsEligible(false);
            result.setRiskLevel("High");
            throw new BadRequestException("User is not eligible for the requested loan");
        }

        result.setCalculatedAt(new Timestamp(System.currentTimeMillis()));
        return repository.save(result);
    }

    @Override
    public EligibilityResult getEligibilityResult(LoanRequest loan) {
        return repository.findByLoanRequest(loan)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Eligibility result not found for loan id: " + loan.getId())
                );
    }
}
