package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.entity.LoanRequest;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;

    public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository) {
        this.loanRequestRepository = loanRequestRepository;
    }

    @Override
    public LoanRequest getLoanById(Long id) {
        return loanRequestRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Loan request not found with id: " + id)
                );
    }

    @Override
    public LoanRequest createLoan(LoanRequest loanRequest) {
        if (loanRequest == null) {
            throw new BadRequestException("Loan request cannot be null");
        }
        if (loanRequest.getAmount() <= 0) {
            throw new BadRequestException("Loan amount must be greater than zero");
        }
        return loanRequestRepository.save(loanRequest);
    }
}
