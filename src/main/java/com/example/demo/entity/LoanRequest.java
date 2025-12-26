package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "loan_requests")
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private BigDecimal requestedAmount;

    @Column(nullable = false)
    private Integer tenureMonths;

    @Column
    private String purpose;

    @Column(nullable = false)
    private String status = "PENDING";

    @Column(nullable = false)
    private Timestamp appliedAt;

    public LoanRequest() {}

    public LoanRequest(User user, BigDecimal requestedAmount, Integer tenureMonths, String purpose, 
                      String status, Timestamp appliedAt) {
        this.user = user;
        this.requestedAmount = requestedAmount;
        this.tenureMonths = tenureMonths;
        this.purpose = purpose;
        this.status = status;
        this.appliedAt = appliedAt;
    }

    @PrePersist
    protected void onCreate() {
        appliedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public Integer getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(Integer tenureMonths) {
        this.tenureMonths = tenureMonths;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(Timestamp appliedAt) {
        this.appliedAt = appliedAt;
    }
}
