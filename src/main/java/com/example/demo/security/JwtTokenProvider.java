package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(Long userId, String email, String role) {
        return "dummy.jwt.token";
    }

    public Long getUserIdFromToken(String token) {
        return 1L;
    }

    public String getEmailFromToken(String token) {
        return "test@email.com";
    }

    public String getRoleFromToken(String token) {
        return "USER";
    }

    public boolean validateToken(String token) {
        return token != null;
    }
}
