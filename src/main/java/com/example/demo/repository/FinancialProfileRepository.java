package com.example.demo.repository;

import com.example.demo.model.FinancialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialProfileRepository extends JpaRepository<FinancialProfile, Long> {
    FinancialProfile findByUserId(Long userId);
}
