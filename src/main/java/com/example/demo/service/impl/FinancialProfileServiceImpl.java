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
    public FinancialProfileServiceImpl(
            FinancialProfileRepository repository) {
        this.repository = repository;
    }

    // INTERFACE METHOD
    @Override
    public FinancialProfile createOrUpdateProfile(
            FinancialProfile profile) {
        return repository.save(profile);
    }

    // TEST METHOD (EXPECTED BY TESTS)
    public FinancialProfile createOrUpdate(
            FinancialProfile profile) {
        return repository.save(profile);
    }

    // INTERFACE METHOD
    @Override
    public FinancialProfile getProfileByUserId(Long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Financial profile not found for user id: " + userId
                        ));
    }

    // TEST METHOD (EXPECTED BY TESTS)
    public FinancialProfile getByUserId(Long userId) {
        return getProfileByUserId(userId);
    }
}
