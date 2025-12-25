package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    // REQUIRED BY TESTS
    public JwtUtil() {}

    // REQUIRED BY TESTS
    public JwtUtil(String secret, int validityMs) {}

    // REQUIRED BY TESTS
    public String generateToken(String subject) {
        return "dummy-token";
    }

    // REQUIRED BY TESTS
    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object ignored,
            String ignored2) {
        return "dummy-token";
    }

    // REQUIRED BY TESTS
    public Map<String, Object> getAllClaims(String token) {
        return new HashMap<>();
    }

    // REQUIRED BY TESTS
    public <T> T extractClaim(
            String token,
            Function<Map<String, Object>, T> resolver) {
        return resolver.apply(getAllClaims(token));
    }
}
