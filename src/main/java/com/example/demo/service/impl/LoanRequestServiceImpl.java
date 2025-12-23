package com.example.demo.service.impl;

import com.example.demo.model.LoanRequest;
import com.example.demo.model.User;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

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
                // Handle user not found: ignore or return null
                return null; // You can choose to return null or throw some other custom handling
            }
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
        // Return null if not found
        return loanRequestRepository.findById(id).orElse(null);
    }

    @Override
    public List<LoanRequest> getAllRequests() {
        return loanRequestRepository.findAll();
    }
}
