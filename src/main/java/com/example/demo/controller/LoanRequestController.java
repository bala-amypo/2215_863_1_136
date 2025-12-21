package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    @PostMapping("/")
    public String submitRequest() {
        return "Submit Loan Request";
    }

    @GetMapping("/user/{userId}")
    public String getUserRequests(@PathVariable Long userId) {
        return "Get Loan Requests for user " + userId;
    }

    @GetMapping("/{id}")
    public String getRequestById(@PathVariable Long id) {
        return "Get Loan Request " + id;
    }

    @GetMapping("/")
    public String getAllRequests() {
        return "List all loan requests";
    }
}
