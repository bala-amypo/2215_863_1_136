package com.example.demo.service;

import com.example.demo.dto.LoanDtos;
import com.example.demo.entity.LoanRequest;

import java.util.List;

public interface LoanRequestService {
    LoanRequest create(LoanDtos.LoanRequestDto dto);
    List<LoanRequest> getByUserId(Long userId);
    LoanRequest getById(Long id);
    List<LoanRequest> getAll();
}