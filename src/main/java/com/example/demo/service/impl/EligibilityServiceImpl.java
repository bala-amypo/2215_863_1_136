package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl {

    // REQUIRED BY TESTS
    public EligibilityServiceImpl() {}

    // REQUIRED BY TESTS
    public boolean isEligible(int creditScore, double dtiRatio) {
        return creditScore >= 650 && dtiRatio < 0.5;
    }
}
