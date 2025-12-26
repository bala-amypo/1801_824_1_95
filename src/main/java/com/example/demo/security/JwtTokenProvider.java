package com.example.demo.security;

public class JwtTokenProvider {

    public JwtTokenProvider() {}

    public String generateToken(Long userId, String email, String role) {
        return "dummy.jwt.token";
    }

    public boolean validateToken(String token) {
        return true;
    }
}
