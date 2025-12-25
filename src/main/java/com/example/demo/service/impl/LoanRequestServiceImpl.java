package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.ResourceNotFoundException;
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
    public LoanRequestServiceImpl(
            LoanRequestRepository repository) {
        this.repository = repository;
    }

    // INTERFACE METHOD
    @Override
    public LoanRequest submitLoanRequest(
            LoanRequest request) {
        return repository.save(request);
    }

    // TEST METHOD
    public LoanRequest submitRequest(
            LoanRequest request) {
        return repository.save(request);
    }

    // INTERFACE METHOD
    @Override
    public LoanRequest getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Loan request not found with id: " + id
                        ));
    }

    // TEST METHOD
    public LoanRequest getById(Long id) {
        return getRequestById(id);
    }

    // TEST METHOD
    public LoanRequest findByLoanRequestId(Long id) {
        return getRequestById(id);
    }

    // TEST METHOD
    public List<LoanRequest> getRequestsByUser(Long userId) {
        return repository.findAll();
    }

    // INTERFACE METHOD
    @Override
    public List<LoanRequest> getAllRequests() {
        return repository.findAll();
    }
}
