package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final RiskAssessmentRepository repository;

    public RiskAssessmentServiceImpl(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskAssessment save(RiskAssessment assessment) {
        return repository.save(assessment);
    }

    @Override
    public RiskAssessment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "RiskAssessment not found with id: " + id)
                );
    }

    @Override
    public List<RiskAssessment> getAll() {
        return repository.findAll();
    }
}
