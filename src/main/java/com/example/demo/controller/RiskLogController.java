package com.example.demo.controller;

import com.example.demo.entity.RiskAssessmentLog;
import com.example.demo.service.RiskAssessmentLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/risk-logs")
public class RiskLogController {

    private final RiskAssessmentLogService riskAssessmentLogService;

    public RiskLogController(RiskAssessmentLogService riskAssessmentLogService) {
        this.riskAssessmentLogService = riskAssessmentLogService;
    }

    /**
     * GET /api/risk-logs/{loanRequestId}
     * Fetch all risk assessment logs for a loan request
     */
    @GetMapping("/{loanRequestId}")
    public List<RiskAssessmentLog> getLogs(
            @PathVariable Long loanRequestId) {

        return riskAssessmentLogService.getLogsByRequest(loanRequestId);
    }
}
