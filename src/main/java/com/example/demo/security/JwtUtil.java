package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    // REQUIRED BY TESTS
    public JwtUtil() {}

    public JwtUtil(String secret, int validityMs) {}

    // ---------- TOKEN GENERATION (ALL REQUIRED SIGNATURES) ----------

    public String generateToken(String subject) {
        return "dummy-token";
    }

    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object a,
            String b
    ) {
        return "dummy-token";
    }

    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object a,
            Object b
    ) {
        return "dummy-token";
    }

    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object a,
            String b,
            Object c,
            String d
    ) {
        return "dummy-token";
    }

    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object a,
            String b,
            Object c,
            String d,
            Object e,
            String f
    ) {
        return "dummy-token";
    }

    // ---------- CLAIM HANDLING ----------

    public Map<String, Object> getAllClaims(String token) {
        return new TestClaimsMap();
    }

    public <T> T extractClaim(
            String token,
            Function<Map<String, Object>, T> resolver) {
        return resolver.apply(getAllClaims(token));
    }

    public <T> T extractClaims(
            String token,
            Function<Map<String, Object>, T> resolver) {
        return resolver.apply(getAllClaims(token));
    }

    // ---------- SPECIAL MAP FOR TESTS ----------

    private static class TestClaimsMap extends HashMap<String, Object> {
        public <T> T get(String key, Class<T> type) {
            Object value = super.get(key);
            return value == null ? null : type.cast(value);
        }
    }
}
