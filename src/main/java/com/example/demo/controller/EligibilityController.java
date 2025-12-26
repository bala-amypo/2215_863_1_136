package com.example.demo.controller;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {

    private final LoanEligibilityService service;

    public EligibilityController(LoanEligibilityService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{id}")
    public EligibilityResult evaluate(@PathVariable Long id) {
        return service.evaluateEligibility(id);
    }

    @GetMapping("/result/{id}")
    public EligibilityResult result(@PathVariable Long id) {
        return service.getResultByRequest(id);
    }
}
