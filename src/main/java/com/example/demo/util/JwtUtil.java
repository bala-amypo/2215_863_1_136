package com.example.demo.util;

import io.jsonwebtoken.*;
import java.util.Date;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;

    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(String subject) {
        return Jwts.builder()
            .setSubject(subject)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public String validateToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
}
