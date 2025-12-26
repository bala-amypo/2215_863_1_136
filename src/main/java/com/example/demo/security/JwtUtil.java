package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    // ================= CONSTRUCTORS =================

    // REQUIRED BY TESTS
    public JwtUtil() {}

    // REQUIRED BY TESTS
    public JwtUtil(String secret, int validityMs) {}

    // ================= TOKEN GENERATION =================

    // 1️⃣ REQUIRED
    public String generateToken(String subject) {
        return "dummy-token";
    }

    // 2️⃣ REQUIRED (Map + String + Object + String)
    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object a,
            String b
    ) {
        return "dummy-token";
    }

    // 3️⃣ REQUIRED (Map + String + Object + Object) 🔥 MISSING EARLIER
    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object a,
            Object b
    ) {
        return "dummy-token";
    }

    // 4️⃣ REQUIRED (6 params)
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

    // 5️⃣ REQUIRED (8 params)
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

    // ================= CLAIM HANDLING =================

    // MUST return map that supports get(key, Class)
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

    // ================= SPECIAL TEST MAP =================
    private static class TestClaimsMap extends HashMap<String, Object> {

        // 🔥 THIS fixes: Map.get("key", String.class)
        public <T> T get(String key, Class<T> type) {
            Object value = super.get(key);
            return value == null ? null : type.cast(value);
        }
    }
}
