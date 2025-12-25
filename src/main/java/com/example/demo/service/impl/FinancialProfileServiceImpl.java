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

    public FinancialProfileServiceImpl(
            FinancialProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public FinancialProfile createOrUpdateProfile(
            FinancialProfile profile) {
        return repository.save(profile);
    }

    // CONTROLLER METHOD
    @Override
    public FinancialProfile getProfileByUserId(Long userId) {
        return getByUserId(userId);
    }

    // TEST METHOD
    @Override
    public FinancialProfile getByUserId(Long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Financial profile not found for user id: " + userId
                        ));
    }
}
