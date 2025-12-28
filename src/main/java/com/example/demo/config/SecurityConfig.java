package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                // Swagger requires login
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).authenticated()

                // APIs also secured
                .anyRequest().authenticated()
            )

            // ✅ SESSION-BASED LOGIN (LOGIN ONCE)
            .formLogin(form -> form
                .defaultSuccessUrl("/swagger-ui/index.html", true)
            )

            .logout(logout -> logout.logoutSuccessUrl("/login"));

        return http.build();
    }
}
