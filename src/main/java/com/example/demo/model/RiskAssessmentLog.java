package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class RiskAssessmentLog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanRequestedId;
    private Double dtiRatio;
    private String creditCheckStatus;

    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
}