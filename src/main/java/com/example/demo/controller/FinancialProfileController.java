package com.example.demo.controller;

import com.example.demo.model.FinancialProfile;
import com.example.demo.service.FinancialProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financial-profiles")
public class FinancialProfileController{
    @Autowired
    FinancialProfileService service;

    @PostMapping
    public FinancialProfile save
}