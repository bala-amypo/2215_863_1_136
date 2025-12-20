package com.example.demo.controller;
import com.example.demo.model.RiskAssessmentLog;
import com.example.demo.service.RiskAssessmentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-logs")
public class RiskLogController{
    @Autowired
    RiskAssessmentLogService service;

    @GetMapping("/{LoanRequestId}")
    public List<RiskAssessmentLog>getlogs(@PathVariable Long loanRequestId){
        return service.getLogsByRequest(loanRequestID);
    }
}