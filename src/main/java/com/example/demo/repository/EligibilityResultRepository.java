package com.example.demo.repository;

import com.example.demo.model.EligibilityResult;
import com.example.demo.model.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EligibilityResultRepository extends JpaRepository<EligibilityResult, Long> {
    Optional<EligibilityResult> findByLoanRequest(LoanRequest loanRequest);
}
