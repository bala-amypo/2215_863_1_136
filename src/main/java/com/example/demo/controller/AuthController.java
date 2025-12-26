package com.example.demo.controller;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.service.EligibilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eligibility")
public class EligibilityController {

    private final EligibilityService eligibilityService;

    public EligibilityController(EligibilityService eligibilityService) {
        this.eligibilityService = eligibilityService;
    }

    @PostMapping("/{loanRequestId}")
    public ResponseEntity<EligibilityResult> evaluate(@PathVariable Long loanRequestId) {
        EligibilityResult result = eligibilityService.evaluateEligibility(loanRequestId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{loanRequestId}")
    public ResponseEntity<EligibilityResult> getByLoanRequest(@PathVariable Long loanRequestId) {
        EligibilityResult result = eligibilityService.getByLoanRequestId(loanRequestId);
        return ResponseEntity.ok(result);
    }
}