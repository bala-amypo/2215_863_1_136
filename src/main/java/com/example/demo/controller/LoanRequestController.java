package com.example.demo.controller;

import com.example.demo.entity.LoanRequest;
import com.example.demo.service.LoanRequestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    private final LoanRequestService service;

    public LoanRequestController(LoanRequestService service) {
        this.service = service;
    }

    @PostMapping
    public LoanRequest submit(@RequestBody LoanRequest request) {

        // 🔒 Prevent client from injecting ID
        request.setId(null);

        return service.submitLoanRequest(request);
    }

    @GetMapping("/{id}")
    public LoanRequest get(@PathVariable Long id) {
        return service.getRequestById(id);
    }
}
