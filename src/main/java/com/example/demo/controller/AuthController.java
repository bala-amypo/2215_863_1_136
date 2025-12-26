package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    // ✅ REQUIRED BY TESTS (exact constructor)
    public AuthController(
            UserService service,
            JwtUtil jwtUtil,
            UserRepository userRepository) {
        this.service = service;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setId(null);
        user.setRole("CUSTOMER");
        user.setCreatedAt(null);
        return service.registerUser(user);
    }

    // ✅ MUST return ResponseEntity<AuthResponse>
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {

        // 🔒 Use repository directly (tests mock this)
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            return ResponseEntity
                    .status(401)
                    .body(null);
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
