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
        String risk = dti < 0.3 ? "LOW" : dti < 0.5 ? "MEDIUM" : "HIGH";
        EligibilityResult result = new EligibiltyResult();
        result.setLoanRequest(request);

        result.setIsEligible(profile.getCreditScore() >=650 && dti < 0.5);
        result.setRiskLevel(risk);

        result.setMaxEligibleAmount(profile.getMonthyIncome() * 20);
        resultRepo.save(result);
        RiskAssessmentLog log = new RiskAssessmentLog();

        log.setLoanRequestId(loanRequestId);
        log.setDtiRatio(dti);
        log.setCreditCheckStatus("DONE");
        logRepo.save(log);

        return result;
    }
    public EligibilityResult getResultByRequest(Long requestID){
        return resultRepo.findByLoanRequestId(requestId);
    }
}