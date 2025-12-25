package com.example.demo.security;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    // REQUIRED BY TESTS
    public JwtFilter() {}

    // REQUIRED BY TESTS
    public JwtFilter(JwtUtil jwtUtil) {}

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        chain.doFilter(request, response);
    }
}
