package com.example.demo.service;

import com.example.demo.model.RiskAssessmentLog;
import java.util.List;

public interface RiskAssessmentLogService {
    void logRisk(RiskAssessmentLog log);
    List<RiskAssessmentLog> getLogsForLoan(Long loanRequestId);
}
