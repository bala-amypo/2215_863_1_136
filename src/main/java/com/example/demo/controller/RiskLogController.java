package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-logs")
public class RiskLogController {

    @GetMapping("/{loanRequestId}")
    public String getLogs(@PathVariable Long loanRequestId) {
        return "Get risk logs for loan " + loanRequestId;
    }
}
