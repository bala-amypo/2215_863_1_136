package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskAssessmentLog;
import com.example.demo.repository.RiskAssessmentLogRepository;
import com.example.demo.service.RiskAssessmentLogService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RiskAssessmentLogServiceImpl implements RiskAssessmentLogService {

    private final RiskAssessmentLogRepository repository;

    public RiskAssessmentLogServiceImpl(RiskAssessmentLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logRisk(RiskAssessmentLog log) {

        if (log.getTimestamp() == null) {
            log.setTimestamp(new Timestamp(System.currentTimeMillis()));
        }

        repository.save(log);
    }

    @Override
    public List<RiskAssessmentLog> getLogsForLoan(Long loanRequestId) {

        List<RiskAssessmentLog> logs = repository.findByLoanRequestId(loanRequestId);

        if (logs.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No risk logs found for loan id: " + loanRequestId
            );
        }

        return logs;
    }
}
