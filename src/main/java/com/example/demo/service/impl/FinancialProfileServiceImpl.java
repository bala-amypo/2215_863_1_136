package com.example.demo.service.impl;
import com.example.demo.model.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframe.sterotype.Service;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService{
    @Autowired
    FinancialProfileRepository repo;

    public FinancialProfile createOrUpdateProfile(FinancialProfile profile){
        return repo.save(profile);
    }
    public FinancialProfile getProfileByUser(Long userId){
        return repo.findByUserId(userId);
    }
}
