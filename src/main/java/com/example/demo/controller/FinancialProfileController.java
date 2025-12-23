package com.example.demo.controller;

import com.example.demo.dto.FinancialProfileRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financial-profiles")
public class FinancialProfileController {

    @PostMapping
    public String createOrUpdateProfile(
            @RequestBody FinancialProfileRequest request) {
        return "Profile saved. Income: " + request.getIncome();
    }

    @GetMapping("/user/{userId}")
    public String getProfile(@PathVariable Long userId) {
        return "Get profile for user " + userId;
    }
}
