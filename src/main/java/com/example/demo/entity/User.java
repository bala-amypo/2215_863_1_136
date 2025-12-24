package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
    name = "users",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role = "CUSTOMER";

    private Timestamp createdAt;

    // ✅ 1. Default constructor (MANDATORY for JPA)
    public User() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 2. Parameterized constructor
    public User(String fullName, String email, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    // ✅ 3. Getter & Setter for ID (IMPORTANT for tests)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ✅ 4. Full Name
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // ✅ 5. Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ✅ 6. Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ✅ 7. Role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // ✅ 8. Created At
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
