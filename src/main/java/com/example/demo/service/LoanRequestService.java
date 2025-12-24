package com.example.demo.service;

import com.example.demo.entity.LoanRequest;

import java.util.List;

public interface LoanRequestService {
    LoanRequest submitLoanRequest(LoanRequest request);
    List<LoanRequest> getAllRequests();
}
