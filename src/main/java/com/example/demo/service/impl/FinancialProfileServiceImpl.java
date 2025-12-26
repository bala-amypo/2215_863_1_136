package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl
        implements FinancialProfileService {

    private FinancialProfileRepository repository;

    // REQUIRED BY TESTS
    public FinancialProfileServiceImpl() {}

    // REQUIRED BY TESTS
    public FinancialProfileServiceImpl(FinancialProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {
        return repository.save(profile);
    }

    // REQUIRED BY TESTS
    public FinancialProfile createOrUpdate(FinancialProfile profile) {
        return repository.save(profile);
    }

    @Override
    public FinancialProfile getProfileByUserId(Long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Financial profile not found for user id: " + userId
                        ));
    }

    // REQUIRED BY TESTS
    public FinancialProfile getByUserId(Long userId) {
        return repository.findByUserId(userId).orElse(null);
    }
}
