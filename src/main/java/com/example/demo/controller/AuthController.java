package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return "User registered: " + request.getUsername();
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return "User logged in: " + request.getUsername();
    }
}
