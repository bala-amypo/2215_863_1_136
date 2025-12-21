package com.example.demo.service;

import com.example.demo.model.FinancialProfile;
import com.example.demo.model.User;

public interface FinancialProfileService {
    FinancialProfile createOrUpdateProfile(FinancialProfile profile);
    FinancialProfile getProfileByUser(User user);
}
