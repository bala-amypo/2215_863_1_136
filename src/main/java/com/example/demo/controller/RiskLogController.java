package com.example.demo.controller;

import com.example.demo.entity.RiskAssessmentLog;
import com.example.demo.service.RiskAssessmentLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-logs")
public class RiskLogController {

    private final RiskAssessmentLogService riskAssessmentLogService;

    public RiskLogController(RiskAssessmentLogService riskAssessmentLogService) {
        this.riskAssessmentLogService = riskAssessmentLogService;
    }

    @GetMapping("/{loanRequestId}")
    public ResponseEntity<List<RiskAssessmentLog>> getByLoanRequestId(@PathVariable Long loanRequestId) {
        return ResponseEntity.ok(riskAssessmentLogService.getByLoanRequestId(loanRequestId));
    }
}