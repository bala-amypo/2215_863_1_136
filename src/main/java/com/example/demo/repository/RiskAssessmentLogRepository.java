package com.example.demo.repository;

import com.example.demo.model.RiskAssessment;
import com.example.demo.model.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiskAssessmentLogRepository extends JpaRepository<RiskAssessment, Long> {

    Optional<RiskAssessment> findByLoanRequest(LoanRequest loanRequest);
}
