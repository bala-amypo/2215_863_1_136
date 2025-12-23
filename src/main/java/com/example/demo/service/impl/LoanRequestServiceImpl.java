package com.example.demo.service.impl;

import com.example.demo.model.LoanRequest;
import com.example.demo.model.User;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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

        // Attach managed User if present
        if (loanRequest.getUser() != null && loanRequest.getUser().getId() != null) {
            Optional<User> userOpt = userRepository.findById(loanRequest.getUser().getId());
            if (userOpt.isPresent()) {
                loanRequest.setUser(userOpt.get());
            } else {
                // User not found
                throw new IllegalArgumentException("User with ID " + loanRequest.getUser().getId() + " not found");
            }
        } else {
            throw new IllegalArgumentException("LoanRequest must have a valid user");
        }

        // Set appliedAt if not already set
        if (loanRequest.getAppliedAt() == null) {
            loanRequest.setAppliedAt(new Timestamp(System.currentTimeMillis()));
        }

        // Set default status if null or empty
        if (loanRequest.getStatus() == null || loanRequest.getStatus().isEmpty()) {
            loanRequest.setStatus("PENDING");
        }

        return loanRequestRepository.save(loanRequest);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(User user) {
        if (user == null || user.getId() == null) {
            return List.of(); // return empty list if user is invalid
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
