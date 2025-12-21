package com.example.demo.service;

import com.example.demo.model.RiskAssessmentLog;
import java.util.List;

public interface RiskAssessmentLogService {
    void logAssessment(RiskAssessmentLog log);
    List<RiskAssessmentLog> getLogsByRequest(Long loanRequestId);
}
