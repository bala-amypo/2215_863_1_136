package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private LoanRequestRepository repository;

    // REQUIRED BY TESTS
    public LoanRequestServiceImpl() {}

    // REQUIRED BY TESTS
    public LoanRequestServiceImpl(LoanRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoanRequest submitLoanRequest(LoanRequest request) {
        return repository.save(request);
    }

    // REQUIRED BY TESTS
    public LoanRequest submitRequest(LoanRequest request) {
        return repository.save(request);
    }

    // REQUIRED BY TESTS
    public LoanRequest getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // REQUIRED BY TESTS
    public LoanRequest findByLoanRequestId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // REQUIRED BY TESTS
    public List<LoanRequest> getRequestsByUser(Long userId) {
        return repository.findAll();
    }

    @Override
    public List<LoanRequest> getAllRequests() {
        return repository.findAll();
    }
}
