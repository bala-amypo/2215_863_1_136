package com.example.demo.service.impl;

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

    @Override
    public LoanRequest submitRequest(LoanRequest loanRequest) {
        return loanRequestRepository.save(loanRequest);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(User user) {
        if (user == null) {
            return List.of(); // prevents NullPointerException
        }
        return loanRequestRepository.findByUser(user);
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return loanRequestRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<LoanRequest> getAllRequests() {
        return loanRequestRepository.findAll();
    }
}
