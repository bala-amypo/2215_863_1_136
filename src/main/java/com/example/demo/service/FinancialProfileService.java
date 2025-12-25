package com.example.demo.service;

import com.example.demo.entity.FinancialProfile;

public interface FinancialProfileService {

    FinancialProfile createOrUpdateProfile(FinancialProfile profile);

    // USED BY CONTROLLER
    FinancialProfile getProfileByUserId(Long userId);

    // USED BY TESTS
    FinancialProfile getByUserId(Long userId);
}
