package com.example.demo.service;

import com.example.demo.entity.LoanRequest;
import java.util.List;

public interface LoanRequestService {

    LoanRequest submitLoanRequest(LoanRequest request);

    // REQUIRED BY TESTS
    LoanRequest getById(Long id);

    LoanRequest getRequestById(Long id);

    List<LoanRequest> getAllRequests();
}
