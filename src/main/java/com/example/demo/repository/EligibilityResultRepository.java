package com.example.demo.repository;

import com.example.demo.entity.EligibilityResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EligibilityResultRepository
        extends JpaRepository<EligibilityResult, Long> {

    // 🔥 REQUIRED BY SERVICES & TESTS
    Optional<EligibilityResult> findByLoanRequestId(Long loanRequestId);

    // 🔐 Safety alias (keeps JPA happy if relationship exists)
    Optional<EligibilityResult> findByLoanRequest_Id(Long loanRequestId);
}
