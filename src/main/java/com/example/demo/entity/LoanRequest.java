// src/main/java/com/example/demo/entity/LoanRequest.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "loan_requests")
public class LoanRequest {

    public enum Status { PENDING, APPROVED, REJECTED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double requestedAmount;

    private Integer tenureMonths;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // stored as String because tests compare to LoanRequest.Status.PENDING.name()
    private String status;

    private Instant submittedAt;

    @PrePersist
    public void prePersist() {
        // t28_loan_request_persist_sets_defaults:
        // if status not set before save, default to PENDING
        if (status == null) {
            status = Status.PENDING.name();
        }
        // if submittedAt not set, initialize now
        if (submittedAt == null) {
            submittedAt = Instant.now();
        }
    }

    // getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getRequestedAmount() { return requestedAmount; }

    public void setRequestedAmount(Double requestedAmount) { this.requestedAmount = requestedAmount; }

    public Integer getTenureMonths() { return tenureMonths; }

    public void setTenureMonths(Integer tenureMonths) { this.tenureMonths = tenureMonths; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Instant getSubmittedAt() { return submittedAt; }

    public void setSubmittedAt(Instant submittedAt) { this.submittedAt = submittedAt; }
}