package com.example.demo.service.impl;

import com.example.demo.model.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository profileRepo;

    public FinancialProfileServiceImpl(FinancialProfileRepository profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {
        FinancialProfile existing = profileRepo.findByUserId(profile.getUser().getId());
        if (existing != null) {
            // Update existing
            existing.setMonthlyIncome(profile.getMonthlyIncome());
            existing.setMonthlyExpenses(profile.getMonthlyExpenses());
            existing.setExistingLoanEmi(profile.getExistingLoanEmi());
            existing.setCreditScore(profile.getCreditScore());
            existing.setSavingsBalance(profile.getSavingsBalance());
            existing.setLastUpdatedAt(profile.getLastUpdatedAt());
            return profileRepo.save(existing);
        }
        return profileRepo.save(profile);
    }

    @Override
    public FinancialProfile getProfileByUser(Long userId) {
        FinancialProfile profile = profileRepo.findByUserId(userId);
        if (profile == null) {
            throw new RuntimeException("Financial profile not found");
        }
        return profile;
    }
}
