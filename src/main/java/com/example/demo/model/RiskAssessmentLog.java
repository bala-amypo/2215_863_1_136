package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class RiskAssessmentLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanRequestId;
    private Double dtiRatio;
    private String creditCheckStatus;
    private Timestamp timestamp;
}
