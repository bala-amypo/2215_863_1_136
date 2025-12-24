package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        // 🔒 Enforce server-side control
        user.setId(null);          // prevent manual ID injection
        user.setRole("CUSTOMER");  // enforce default role
        user.setCreatedAt(null);   // prevent client timestamp injection

        return service.registerUser(user);
    }
}
