package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.LoanRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    private final LoanRequestService loanRequestService;
    private final UserRepository userRepository;

    public LoanRequestController(LoanRequestService loanRequestService,
                                 UserRepository userRepository) {
        this.loanRequestService = loanRequestService;
        this.userRepository = userRepository;
    }

    // ✅ POST – Submit loan request
    @PostMapping
    public LoanRequest submitRequest(@RequestBody LoanRequest loanRequest) {

        if (loanRequest.getUser() == null || loanRequest.getUser().getId() == null) {
            throw new ResourceNotFoundException("User ID must be provided");
        }

        // Load managed User entity from DB
        User user = userRepository.findById(loanRequest.getUser().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + loanRequest.getUser().getId()
                        )
                );

        loanRequest.setUser(user);

        return loanRequestService.submitRequest(loanRequest);
    }

    // ✅ GET – Get all loan requests
    @GetMapping
    public List<LoanRequest> getAllRequests() {
        return loanRequestService.getAllRequests();
    }

    // ✅ GET – Get loan requests by user ID
    @GetMapping("/user/{userId}")
    public List<LoanRequest> getRequestsByUser(@PathVariable Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + userId)
                );

        return loanRequestService.getRequestsByUser(user);
    }

    // ✅ GET – Get loan request by ID
    @GetMapping("/{id}")
    public LoanRequest getRequestById(@PathVariable Long id) {
        return loanRequestService.getRequestById(id);
    }
}
