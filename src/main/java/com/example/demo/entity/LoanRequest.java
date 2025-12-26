package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "loan_request")
public class LoanRequest {

    // ✅ STATUS ENUM (required by tests)
    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private Double requestedAmount;
    private Integer tenureMonths;
    private String purpose;

    // 🔹 Stored as String but enum-compatible
    private String status;

    private Timestamp appliedAt;

    // ✅ Default constructor (JPA + tests)
    public LoanRequest() {
        this.status = Status.PENDING.name();
        this.appliedAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ Parameterized constructor
    public LoanRequest(User user,
                       Double requestedAmount,
                       Integer tenureMonths,
                       String purpose) {
        this.user = user;
        this.requestedAmount = requestedAmount;
        this.tenureMonths = tenureMonths;
        this.purpose = purpose;
        this.status = Status.PENDING.name();
        this.appliedAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ✅ User
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // ✅ Requested Amount
    public Double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(Double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    // ✅ Tenure Months
    public Integer getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(Integer tenureMonths) {
        this.tenureMonths = tenureMonths;
    }

    // ✅ Purpose
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    // ✅ Status (String-based, backward compatible)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ✅ Enum-friendly setter (for tests)
    public void setStatus(Status status) {
        this.status = status.name();
    }

    // ✅ Applied At
    public Timestamp getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(Timestamp appliedAt) {
        this.appliedAt = appliedAt;
    }

    // ✅ TEST COMPATIBILITY METHOD
    // Tests expect getSubmittedAt()
    public Timestamp getSubmittedAt() {
        return this.appliedAt;
    }
}
