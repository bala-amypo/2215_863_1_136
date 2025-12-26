package com.example.demo.service;

import com.example.demo.dto.LoanDtos;
import com.example.demo.entity.FinancialProfile;

public interface FinancialProfileService {
    FinancialProfile create(LoanDtos.FinancialProfileDto dto);
    FinancialProfile getByUserId(Long userId);
}