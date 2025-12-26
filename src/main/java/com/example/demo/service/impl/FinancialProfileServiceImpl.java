// src/main/java/com/example/demo/service/impl/FinancialProfileServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

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
    public FinancialProfile createOrUpdate(FinancialProfile profile) {
        if (profile.getCreditScore() != null &&
                (profile.getCreditScore() < 300 || profile.getCreditScore() > 900)) {
            throw new BadRequestException("Invalid credit score");
        }

        Long userId = profile.getUser() != null ? profile.getUser().getId() : null;
        if (userId == null) {
            throw new BadRequestException("User required");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Optional<FinancialProfile> existingOpt = financialProfileRepository.findByUserId(userId);
        FinancialProfile toSave;
        if (existingOpt.isPresent()) {
            FinancialProfile existing = existingOpt.get();
            existing.setMonthlyIncome(profile.getMonthlyIncome());
            existing.setMonthlyExpenses(profile.getMonthlyExpenses());
            existing.setExistingLoanEmi(profile.getExistingLoanEmi());
            existing.setCreditScore(profile.getCreditScore());
            existing.setSavingsBalance(profile.getSavingsBalance());
            toSave = existing;
        } else {
            profile.setUser(user);
            toSave = profile;
        }

        // Explicitly set lastUpdatedAt so tests see it with mocked repo (t29)
        toSave.setLastUpdatedAt(Instant.now());

        return financialProfileRepository.save(toSave);
    }

    @Override
    public FinancialProfile getByUserId(Long userId) {
        return financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }
}