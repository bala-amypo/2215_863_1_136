package com.example.demo.controller;

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

    // ✅ POST – submit loan request
    @PostMapping
    public LoanRequest submitRequest(@RequestBody LoanRequest loanRequest) {
        return loanRequestService.submitRequest(loanRequest);
    }

    // ✅ GET – get all loan requests
    @GetMapping
    public List<LoanRequest> getAllRequests() {
        return loanRequestService.getAllRequests();
    }

    // ✅ GET – get loan requests by user
    @GetMapping("/user/{userId}")
    public List<LoanRequest> getRequestsByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return loanRequestService.getRequestsByUser(user);
    }

    // ✅ GET – get loan request by ID
    @GetMapping("/{id}")
    public LoanRequest getRequestById(@PathVariable Long id) {
        return loanRequestService.getRequestById(id);
    }
}
