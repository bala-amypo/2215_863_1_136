package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    // ✅ REQUIRED BY TESTS
    public UserServiceImpl() {}

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public UserServiceImpl(UserRepository repository,
                           PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new BadRequestException("Email is required");
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new BadRequestException("Password is required");
        }

        if (repository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already registered");
        }

        if (passwordEncoder != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return repository.save(user);
    }

    // ✅ REQUIRED BY TESTS (alias)
    public User register(User user) {
        return registerUser(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    // ✅ REQUIRED BY TESTS
    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
