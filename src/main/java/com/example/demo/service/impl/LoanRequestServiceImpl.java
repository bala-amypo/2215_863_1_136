package com.example.demo.service.impl;

import com.example.demo.model.LoanRequest;
import com.example.demo.model.User;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;
    private final UserRepository userRepository;

    public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository,
                                  UserRepository userRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LoanRequest submitRequest(LoanRequest loanRequest) {

        // 🔴 CRITICAL FIX: attach managed User
        if (loanRequest.getUser() != null && loanRequest.getUser().getId() != null) {

            User user = userRepository
                    .findById(loanRequest.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            loanRequest.setUser(user);
        }

        return loanRequestRepository.save(loanRequest);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(User user) {
        if (user == null) {
            return List.of();
        }
        return loanRequestRepository.findByUser(user);
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return loanRequestRepository.findById(id).orElse(null);
    }

    @Override
    public List<LoanRequest> getAllRequests() {
        return loanRequestRepository.findAll();
    }
}
