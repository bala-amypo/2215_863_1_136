package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Component   // ✅ REQUIRED so Spring can manage this class
public class JwtUtil {

    // 🔒 Keep secret strong (length matters for HS256)
    private static final String SECRET =
            "mySecretKey12345mySecretKey12345";

    private static final long VALIDITY_MS = 60 * 60 * 1000; // 1 hour

    // ✅ Correct way to build key for jjwt (avoids runtime errors)
    private static final SecretKey KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_MS))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return resolver.apply(claims);
    }

    public boolean isTokenValid(String token) {
        return extractExpiration(token).after(new Date());
    }
}
