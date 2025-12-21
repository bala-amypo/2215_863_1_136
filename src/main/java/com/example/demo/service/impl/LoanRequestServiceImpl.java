package com.example.demo.service.impl;

import com.example.demo.model.LoanRequest;
import com.example.demo.model.User;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository repository;

    public LoanRequestServiceImpl(LoanRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoanRequest submitRequest(LoanRequest request) {
        return repository.save(request);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<LoanRequest> getAllRequests() {
        return repository.findAll();
    }
}
