package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    private String role; // ADMIN / CUSTOMER

    private Timestamp createdAt;
}
