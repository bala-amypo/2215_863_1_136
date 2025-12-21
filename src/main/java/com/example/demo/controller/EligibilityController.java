package com.example.demo.controller;

import com.example.demo.model.EligibilityResult;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {

    @Autowired
    LoanEligibilityService service;

    @PostMapping("/evaluate/{loanRequestId}")
    public EligibilityResult evaluate(@PathVariable Long loanRequestId) {
        return service.evaluateEligibility(loanRequestId);
    }

    @GetMapping("/result/{loanRequestId}")
    public EligibilityResult result(@PathVariable Long loanRequestId) {
        return service.getResultByRequest(loanRequestId);
    }
}
