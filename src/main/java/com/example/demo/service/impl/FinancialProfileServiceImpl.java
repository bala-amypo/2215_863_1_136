package com.example.demo.service.impl;

import com.example.demo.dto.LoanDtos;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository financialProfileRepository;
    private final UserRepository userRepository;

    public FinancialProfileServiceImpl(FinancialProfileRepository financialProfileRepository, 
                                     UserRepository userRepository) {
        this.financialProfileRepository = financialProfileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {
        return financialProfileRepository.save(profile);
    }

    public FinancialProfile create(LoanDtos.FinancialProfileDto dto) {
        if (financialProfileRepository.findByUserId(dto.getUserId()).isPresent()) {
            throw new BadRequestException("Financial profile already exists");
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        FinancialProfile profile = new FinancialProfile();
        profile.setUser(user);
        profile.setMonthlyIncome(dto.getMonthlyIncome());
        profile.setMonthlyExpenses(dto.getMonthlyExpenses());
        profile.setExistingLoanEmi(dto.getExistingLoanEmi());
        profile.setCreditScore(dto.getCreditScore());
        profile.setSavingsBalance(dto.getSavingsBalance());
        profile.setLastUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return financialProfileRepository.save(profile);
    }

    @Override
    public FinancialProfile getProfileByUserId(Long userId) {
        return financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));
    }

    @Override
    public FinancialProfile getByUserId(Long userId) {
        return financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));
    }
}
