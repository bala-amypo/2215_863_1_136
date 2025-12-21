package com.example.demo.service.impl;

import com.example.demo.model.RiskAssessmentLog;
import com.example.demo.repository.RiskAssessmentLogRepository;
import com.example.demo.service.RiskAssessmentLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssessmentLogServiceImpl implements RiskAssessmentLogService {

    private final RiskAssessmentLogRepository logRepo;

    public RiskAssessmentLogServiceImpl(RiskAssessmentLogRepository logRepo) {
        this.logRepo = logRepo;
    }

    @Override
    public void logAssessment(RiskAssessmentLog log) {
        logRepo.save(log);
    }

    @Override
    public List<RiskAssessmentLog> getLogsByRequest(Long loanRequestId) {
        return logRepo.findByLoanRequestId(loanRequestId);
    }
}
