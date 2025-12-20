package com.example.demo.service.impl;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sterotype.Service;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService{
    @Autowired LoanRequestRepository loanRepo;
    @Autowired FinancialProfileRepository profileRepo;
    @Autowired EligibiltyResultRepository resultRepo;
    @Autowired RiskAssessmentLogRepository logpo;

    public EligibilityResult evaluateEligibility(Long loanRequestId){
        LoanRequest request = loanRepo.findbyId(loanRequestId).orElseThrow();
        FinancialProfile profile = profile.findById(request.getUser().getId());
        double dti = profile.getExistingLoanEmi()/profile.getMonthlyIncome();
        String risk = dti < 0.3 ? "LOW" : dti < 0.5
    }
}