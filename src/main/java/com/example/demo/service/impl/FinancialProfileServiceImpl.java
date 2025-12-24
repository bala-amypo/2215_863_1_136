package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository financialProfileRepository;

    public FinancialProfileServiceImpl(FinancialProfileRepository financialProfileRepository) {
        this.financialProfileRepository = financialProfileRepository;
    }

    @Override
    public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {
        if (financialProfileRepository.findByUserId(profile.getUser().getId()).isPresent()) {
            throw new BadRequestException("Financial profile already exists");
        }
        return financialProfileRepository.save(profile);
    }

    @Override
    public FinancialProfile getProfileByUserId(Long userId) {
        return financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
