package com.example.demo.service.impl;

import com.example.demo.model.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRepo;

    public LoanRequestServiceImpl(LoanRequestRepository loanRepo) {
        this.loanRepo = loanRepo;
    }

    @Override
    public LoanRequest submitLoanRequest(LoanRequest request) {
        if (request.getRequestedAmount() <= 0) {
            throw new RuntimeException("Requested amount must be positive");
        }
        if (request.getTenureMonths() <= 0) {
            throw new RuntimeException("Tenure must be positive");
        }
        request.setStatus("PENDING");
        return loanRepo.save(request);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(Long userId) {
        return loanRepo.findByUserId(userId);
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return loanRepo.findById(id).orElseThrow(() -> new RuntimeException("Loan request not found"));
    }

    @Override
    public List<LoanRequest> getAllRequests() {
        return loanRepo.findAll();
    }
}
