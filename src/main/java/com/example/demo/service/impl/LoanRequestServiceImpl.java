package com.example.demo.service.impl;

import com.example.demo.model.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    @Autowired
    LoanRequestRepository repo;

    public LoanRequest submitLoanRequest(LoanRequest request) {
        return repo.save(request);
    }

    public List<LoanRequest> getRequestsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public LoanRequest getRequestById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<LoanRequest> getAllRequests() {
        return repo.findAll();
    }
}
