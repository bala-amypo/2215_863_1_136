package com.example.demo.repository;

import com.example.demo.entity.EligibilityResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EligibilityResultRepository
        extends JpaRepository<EligibilityResult, Long> {

    // ✅ Correct way: navigate through the entity relationship
    Optional<EligibilityResult> findByLoanRequest_Id(Long loanRequestId);
}
