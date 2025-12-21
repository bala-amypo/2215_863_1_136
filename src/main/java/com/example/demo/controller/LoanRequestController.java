package com.example.demo.controller;

import com.example.demo.dto.LoanRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    // Submit loan request
    @PostMapping
    public String submitRequest(@RequestBody LoanRequestDto request) {
        return "Loan Request submitted. Amount: " + request.getAmount();
    }

    // Get all loan requests
    @GetMapping
    public String getAllRequests() {
        return "List all loan requests";
    }

    // Get loan requests by user
    @GetMapping("/user/{userId}")
    public String getUserRequests(@PathVariable Long userId) {
        return "Get Loan Requests for user " + userId;
    }

    // Get loan request by ID
    @GetMapping("/{id}")
    public String getRequestById(@PathVariable Long id) {
        return "Get Loan Request " + id;
    }
}
