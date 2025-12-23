package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Schema(description = "Loan Request model")
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double requestedAmount;
    private Integer tenureMonths;
    private String purpose;

    @Column(nullable = false)
    private String status;

    @CreationTimestamp
    private Timestamp appliedAt;

    public LoanRequest() {}

    // getters & setters (same as yours)
}
