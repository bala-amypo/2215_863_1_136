package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @column(unique = true)
    private String email;
    private String password;
    private String role="CUSTOMER";
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
}