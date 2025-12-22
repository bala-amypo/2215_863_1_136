package com.example.demo.controller;

import com.example.demo.model.LoanRequest;
import com.example.demo.service.LoanRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    private final LoanRequestService loanRequestService;

    public LoanRequestController(LoanRequestService loanRequestService) {
        this.loanRequestService = loanRequestService;
    }

    // ✅ Submit loan request (POST shows body in Swagger)
    @PostMapping
    public LoanRequest submitRequest(@RequestBody LoanRequest request) {
        return loanRequestService.saveLoanRequest(request);
    }

    // ✅ Get all loan requests (THIS FIXES YOUR ISSUE)
    @GetMapping
    public List<LoanRequest> getAllRequests() {
        return loanRequestService.getAllLoanRequests();
    }

    // ✅ Get loan requests by user
    @GetMapping("/user/{userId}")
    public List<LoanRequest> getUserRequests(@PathVariable Long userId) {
        return loanRequestService.getLoanRequestsByUser(userId);
    }

    // ✅ Get loan request by ID
    @GetMapping("/{id}")
    public LoanRequest getRequestById(@PathVariable Long id) {
        return loanRequestService.getLoanRequestById(id);
    }
}
