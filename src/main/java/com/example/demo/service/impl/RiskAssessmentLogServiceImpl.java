package com.example.demo.service.impl;

import com.example.demo.model.RiskAssessmentLog;
import com.example.demo.repository.RiskAssessmentLogRepository;
import com.example.demo.service.RiskAssessmentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssessmentLogServiceImpl implements RiskAssessmentLogService {

    @Autowired
    RiskAssessmentLogRepository repo;

    public List<RiskAssessmentLog> getLogsByRequest(Long loanRequestId) {
        return repo.findByLoanRequestId(loanRequestId);
    }
}
