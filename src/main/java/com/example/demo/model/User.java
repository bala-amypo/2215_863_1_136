package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "User model")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Full name of the user", example = "John Doe")
    private String fullName;

    @Column(unique = true)
    @Schema(description = "Email of the user", example = "john@example.com")
    private String email;

    @Schema(description = "Password of the user", example = "password123")
    private String password;

    @Schema(description = "Role of the user", example = "USER")
    private String role;

    private Timestamp createdAt;

    public User() {}
    public User(Long id, String fullName, String email, String password, String role, Timestamp createdAt) {
        this.id = id; this.fullName = fullName; this.email = email; this.password = password; this.role = role; this.createdAt = createdAt;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
