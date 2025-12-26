package com.example.demo.controller;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.service.FinancialProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financial-profiles")
public class FinancialProfileController {

    private final FinancialProfileService service;

    public FinancialProfileController(FinancialProfileService service) {
        this.service = service;
    }

    @PostMapping
    public FinancialProfile save(@RequestBody FinancialProfile profile) {

        // 🔒 Prevent client from injecting ID
        profile.setId(null);

        return service.createOrUpdateProfile(profile);
    }

    @GetMapping("/user/{id}")
    public FinancialProfile get(@PathVariable Long id) {
        return service.getProfileByUserId(id);
    }
}
