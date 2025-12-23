package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.LoanRequest;
import com.example.demo.model.User;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;

    public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository) {
        this.loanRequestRepository = loanRequestRepository;
    }

    // Submit a new loan request
    @Override
    public LoanRequest submitRequest(LoanRequest loanRequest) {
        if (loanRequest == null) {
            throw new BadRequestException("Loan request cannot be null");
        }
        if (loanRequest.getRequestedAmount() == null || loanRequest.getRequestedAmount() <= 0) {
            throw new BadRequestException("Loan amount must be greater than zero");
        }
        return loanRequestRepository.save(loanRequest);
    }

    // Get all loan requests of a specific user
    @Override
    public List<LoanRequest> getRequestsByUser(User user) {
        return loanRequestRepository.findByUser(user);
    }

    // Get a single loan request by ID
    @Override
    public LoanRequest getRequestById(Long id) {
        return loanRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found with id: " + id));
    }

    // Get all loan requests (ADMIN / STAFF)
    @Override
    public List<LoanRequest> getAllRequests() {
        return loanRequestRepository.findAll();
    }
}
