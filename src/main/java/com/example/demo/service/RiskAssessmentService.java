// src/main/java/com/example/demo/service/RiskAssessmentService.java
package com.example.demo.service;

import com.example.demo.entity.RiskAssessment;

import java.util.List;

public interface RiskAssessmentService {
    RiskAssessment assessRisk(Long loanRequestId);
    RiskAssessment getByLoanRequestId(Long loanRequestId);

    // extra CRUD-style methods used by RiskAssessmentController
    RiskAssessment postData5(RiskAssessment riskAssessment);
    List<RiskAssessment> getAllData5();
    void deleteData5(Long id);
    RiskAssessment getData5(Long id);
    RiskAssessment updateData5(Long id, RiskAssessment riskAssessment);
}