package com.example.demo.controller;

import com.example.demo.entity.LoanRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/loan-requests")
public class LoanRequestController {

    private final LoanRequestService loanRequestService;
    private final UserRepository userRepository;

    public LoanRequestController(LoanRequestService loanRequestService,
                                 UserRepository userRepository) {
        this.loanRequestService = loanRequestService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<LoanRequest> submit(@RequestBody LoanRequest request) {

        // ✅ FIX: load managed User
        Long userId = request.getUser().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        request.setUser(user);

        // ✅ FIX: set server-side fields
        request.setStatus("PENDING");
        request.setSubmittedAt(new Timestamp(System.currentTimeMillis()));

        LoanRequest saved = loanRequestService.submitRequest(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanRequest> getById(@PathVariable Long id) {
        LoanRequest lr = loanRequestService.getById(id);
        return ResponseEntity.ok(lr);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanRequest>> getByUser(@PathVariable Long userId) {
        List<LoanRequest> list = loanRequestService.getRequestsByUser(userId);
        return ResponseEntity.ok(list);
    }
}
