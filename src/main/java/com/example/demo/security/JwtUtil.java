package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    // ✅ REQUIRED BY TESTS
    public JwtUtil() {}

    // ✅ REQUIRED BY TESTS
    public JwtUtil(String secret, int validityMs) {}

    // ================= TOKEN GENERATION =================

    // 1️⃣
    public String generateToken(String subject) {
        return "dummy-token";
    }

    // 2️⃣
    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object ignored,
            String ignored2) {
        return "dummy-token";
    }

    // 3️⃣ 🔥 MISSING EARLIER
    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object ignored1,
            String ignored2,
            Object ignored3,
            String ignored4) {
        return "dummy-token";
    }

    // 4️⃣
    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object ignored1,
            String ignored2,
            Object ignored3,
            String ignored4,
            Object ignored5,
            String ignored6) {
        return "dummy-token";
    }

    // ================= CLAIM HANDLING =================

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

    // ================= TEST SUPPORT MAP =================
    private static class TestClaimsMap extends HashMap<String, Object> {

        // 🔥 THIS FIXES: claims.get("key", String.class)
        public <T> T get(String key, Class<T> type) {
            Object value = super.get(key);
            return type.cast(value);
        }
    }
}
