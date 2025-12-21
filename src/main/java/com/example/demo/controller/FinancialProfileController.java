package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financial-profiles")
public class FinancialProfileController {

    @PostMapping("/")
    public String createOrUpdateProfile() {
        return "Create/Update Profile";
    }

    @GetMapping("/user/{userId}")
    public String getProfile(@PathVariable Long userId) {
        return "Get profile for " + userId;
    }
}
