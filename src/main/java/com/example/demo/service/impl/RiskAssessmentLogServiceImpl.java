package com.example.demo.service.impl;

import com.example.demo.model.RiskAssessmentLog;
import com.example.demo.repository.RiskAssessmentLogRepository;
import com.example.demo.service.RiskAssessmentLogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RiskAssessmentLogServiceImpl implements RiskAssessmentLogService {

    private final RiskAssessmentLogRepository repository;

    public RiskAssessmentLogServiceImpl(RiskAssessmentLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logRisk(RiskAssessmentLog log) {
        repository.save(log);
    }

    @Override
    public List<RiskAssessmentLog> getLogsForLoan(Long loanRequestId) {
        return repository.findByLoanRequestId(loanRequestId);
    }
}
