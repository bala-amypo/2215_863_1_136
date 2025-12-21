package com.example.demo.service.impl;

import com.example.demo.model.FinancialProfile;
import com.example.demo.model.User;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository profileRepository;

    public FinancialProfileServiceImpl(FinancialProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public FinancialProfile getProfileByUser(User user) {
        Optional<FinancialProfile> profile = profileRepository.findByUser(user);
        return profile.orElse(null);
    }
}
