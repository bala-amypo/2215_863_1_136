package com.example.demo.repository;

import com.example.demo.model.EligibilityResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EligibilityResultRepository extends JpaRepository<EligibilityResult, Long> {
EligibilityResult findByLoanRequestId(Long loanRequestId);
}
