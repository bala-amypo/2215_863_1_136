package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {

    @PostMapping("/evaluate/{loanRequestId}")
    public String evaluate(@PathVariable Long loanRequestId) {
        return "Evaluate loan " + loanRequestId;
    }

    @GetMapping("/result/{loanRequestId}")
    public String getResult(@PathVariable Long loanRequestId) {
        return "Get result for loan " + loanRequestId;
    }
}
