package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private String secret = "mySecretKey12345mySecretKey12345";
    private long validityMs = 60 * 60 * 1000;

    // ✅ REQUIRED BY TESTS
    public JwtUtil() {}

    // ✅ REQUIRED BY TESTS
    public JwtUtil(String secret, int validityMs) {
        this.secret = secret;
        this.validityMs = validityMs;
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // ✅ REQUIRED BY TESTS
    public String generateToken(
            Map<String, Object> claims,
            String subject,
            String ignored) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return resolver.apply(claims);
    }
}
