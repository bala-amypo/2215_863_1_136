package com.example.demo.controller;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.service.FinancialProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financial-profiles")
public class FinancialProfileController {

    private final FinancialProfileService financialProfileService;

    public FinancialProfileController(FinancialProfileService financialProfileService) {
        this.financialProfileService = financialProfileService;
    }

    @PostMapping
    public ResponseEntity<FinancialProfile> createOrUpdate(@RequestBody FinancialProfile profile) {
        FinancialProfile saved = financialProfileService.createOrUpdate(profile);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<FinancialProfile> getByUserId(@PathVariable Long userId) {
        FinancialProfile fp = financialProfileService.getByUserId(userId);
        return ResponseEntity.ok(fp);
    }
}