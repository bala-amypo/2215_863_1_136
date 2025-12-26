// src/main/java/com/example/demo/service/impl/RiskAssessmentServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.entity.LoanRequest;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;
    private final RiskAssessmentRepository riskAssessmentRepository;

    public RiskAssessmentServiceImpl(LoanRequestRepository loanRequestRepository,
                                     FinancialProfileRepository financialProfileRepository,
                                     RiskAssessmentRepository riskAssessmentRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    @Override
    public RiskAssessment assessRisk(Long loanRequestId) {
        LoanRequest request = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("LoanRequest not found"));

        if (riskAssessmentRepository.findByLoanRequestId(loanRequestId).isPresent()) {
            throw new BadRequestException("Risk already assessed");
        }

        Long userId = request.getUser().getId();
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        double income = profile.getMonthlyIncome() != null ? profile.getMonthlyIncome() : 0.0;
        double obligations = (profile.getMonthlyExpenses() != null ? profile.getMonthlyExpenses() : 0.0)
                + (profile.getExistingLoanEmi() != null ? profile.getExistingLoanEmi() : 0.0);

        double dti = income == 0 ? 0.0 : (obligations / income);
        double creditScore = profile.getCreditScore() != null ? profile.getCreditScore() : 500;
        double normalizedCs = (creditScore - 300.0) / 600.0;
        double riskScore = 100.0 * (0.6 * dti + 0.4 * (1 - normalizedCs));
        if (riskScore < 0) riskScore = 0;
        if (riskScore > 100) riskScore = 100;

        RiskAssessment ra = new RiskAssessment();
        ra.setLoanRequest(request);
        ra.setDtiRatio(dti);
        ra.setRiskScore(riskScore);
        return riskAssessmentRepository.save(ra);
    }

    @Override
    public RiskAssessment getByLoanRequestId(Long loanRequestId) {
        return riskAssessmentRepository.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Risk not found"));
    }

    // CRUD-style methods for controller

    @Override
    public RiskAssessment postData5(RiskAssessment riskAssessment) {
        return riskAssessmentRepository.save(riskAssessment);
    }

    @Override
    public List<RiskAssessment> getAllData5() {
        return riskAssessmentRepository.findAll();
    }

    @Override
    public void deleteData5(Long id) {
        riskAssessmentRepository.deleteById(id);
    }

    @Override
    public RiskAssessment getData5(Long id) {
        return riskAssessmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RiskAssessment not found"));
    }

    @Override
    public RiskAssessment updateData5(Long id, RiskAssessment newData) {
        RiskAssessment existing = getData5(id);
        existing.setRiskScore(newData.getRiskScore());
        existing.setDtiRatio(newData.getDtiRatio());
        existing.setLoanRequest(newData.getLoanRequest());
        return riskAssessmentRepository.save(existing);
    }
}