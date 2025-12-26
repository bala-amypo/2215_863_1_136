package com.example.demo.controller;

import com.example.demo.dto.LoanDtos;
import com.example.demo.entity.LoanRequest;
import com.example.demo.service.LoanRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    private final LoanRequestService loanRequestService;

    public LoanRequestController(LoanRequestService loanRequestService) {
        this.loanRequestService = loanRequestService;
    }

    @PostMapping("/")
    public ResponseEntity<LoanRequest> create(@RequestBody LoanDtos.LoanRequestDto dto) {
        return ResponseEntity.ok(loanRequestService.create(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanRequest>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(loanRequestService.getByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanRequest> getById(@PathVariable Long id) {
        return ResponseEntity.ok(loanRequestService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<LoanRequest>> getAll() {
        return ResponseEntity.ok(loanRequestService.getAll());
    }
}