package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository,
                           PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {

        // ✅ 1. Check duplicate email (prevents DB crash → 500)
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // ✅ 2. Encrypt password (MANDATORY)
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // ✅ 3. Save user
        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
