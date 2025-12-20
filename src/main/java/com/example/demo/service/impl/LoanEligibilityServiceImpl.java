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

    public Eligibil
}