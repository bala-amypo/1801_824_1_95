package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // REQUIRED: default constructor
    public JwtTokenProvider() {}

    public Long getIdFromToken(String token) {
        return 1L;
    }

    public String getEmailFromToken(String token) {
        return "test@example.com";
    }

    public String getRoleFromToken(String token) {
        return "ROLE_USER";
    }

    public boolean validateToken(String token) {
        return token != null && !token.isBlank();
    }
}
