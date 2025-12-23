package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskAssessment;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.service.RiskAssessmentLogicService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentLogicServiceImpl implements RiskAssessmentLogicService {

    private final RiskAssessmentRepository repository;

    public RiskAssessmentLogicServiceImpl(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskAssessment assessRisk(Long userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Risk assessment data not found for user id: " + userId)
                );
    }
}
