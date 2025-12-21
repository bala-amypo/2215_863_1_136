package com.example.demo.service;

import com.example.demo.model.LoanRequest;
import com.example.demo.model.User;
import java.util.List;

public interface LoanRequestService {
    LoanRequest submitRequest(LoanRequest request);
    List<LoanRequest> getRequestsByUser(User user);
    LoanRequest getRequestById(Long id);
    List<LoanRequest> getAllRequests();
}
