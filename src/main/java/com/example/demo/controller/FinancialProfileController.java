package com.example.demo.controller;

import com.example.demo.dto.LoanDtos;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.service.FinancialProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financial-profiles")
public class FinancialProfileController {

    private final FinancialProfileService financialProfileService;

    public FinancialProfileController(FinancialProfileService financialProfileService) {
        this.financialProfileService = financialProfileService;
    }

    @PostMapping("/")
    public ResponseEntity<FinancialProfile> create(@RequestBody LoanDtos.FinancialProfileDto dto) {
        return ResponseEntity.ok(financialProfileService.create(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<FinancialProfile> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(financialProfileService.getByUserId(userId));
    }
}