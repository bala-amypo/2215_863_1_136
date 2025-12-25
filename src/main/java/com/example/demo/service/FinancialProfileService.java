package com.example.demo.service;

import com.example.demo.entity.FinancialProfile;

public interface FinancialProfileService {

    FinancialProfile createOrUpdateProfile(FinancialProfile profile);

    // REQUIRED BY TESTS
    FinancialProfile getByUserId(Long userId);
}
