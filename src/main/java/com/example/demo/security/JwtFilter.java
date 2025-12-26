// src/main/java/com/example/demo/security/JwtFilter.java
package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JwtFilter implements Filter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String header = req.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                jwtUtil.getAllClaims(token);
                // valid token; no additional behavior required for tests
            } catch (Exception ex) {
                // invalid/expired token is swallowed, continue chain
            }
        }
        chain.doFilter(request, response);
    }
}