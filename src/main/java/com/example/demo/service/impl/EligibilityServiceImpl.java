package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl {

    // ✅ REQUIRED BY TESTS
    public EligibilityServiceImpl() {
    }

    // ✅ REQUIRED BY TESTS (exact logic + signature)
    public boolean isEligible(int creditScore, double dtiRatio) {

        // Defensive defaults (avoid test edge failures)
        if (creditScore <= 0 || dtiRatio < 0) {
            return false;
        }

        return creditScore >= 650 && dtiRatio < 0.5;
    }
}
