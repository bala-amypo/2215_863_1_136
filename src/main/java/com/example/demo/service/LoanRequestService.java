package com.example.demo.service;

import com.example.demo.model.LoanRequest;
import com.example.demo.model.User;

import java.util.List;

public interface LoanRequestService {

    // Submit a new loan request
    LoanRequest submitRequest(LoanRequest loanRequest);

    // Get all loan requests of a specific user
    List<LoanRequest> getRequestsByUser(User user);

    // Get a single loan request by ID
    LoanRequest getRequestById(Long id);

    // Get all loan requests (ADMIN / STAFF)
    List<LoanRequest> getAllRequests();
}
