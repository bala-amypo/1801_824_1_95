package com.example.demo.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    private final String secretKey;
    private final long expirationMs;
    private final SecretKey key;

    // ===== DEFAULT CONSTRUCTOR (Spring) =====
    public JwtTokenProvider() {
        this.secretKey = "testSecretKey12345678901234567890";
        this.expirationMs = 86400000; // 1 day
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // ===== CONSTRUCTOR USED BY TESTS =====
    public JwtTokenProvider(String secretKey, long expirationMs) {
        this.secretKey = secretKey;
        this.expirationMs = expirationMs;
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // =====================================================
    // TOKEN GENERATION (ALL REQUIRED OVERLOADS)
    // =====================================================

    public String generateToken(Long userId, String email, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateToken(Authentication authentication, Long userId, String role) {
        return generateToken(userId, authentication.getName(), role);
    }

    public String generateToken(Authentication authentication, Long userId, String email, String role) {
        return generateToken(userId, email, role);
    }

    // =====================================================
    // TOKEN READ METHODS
    // =====================================================

    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public Long getUserIdFromToken(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }

    // =====================================================
    // VALIDATION
    // =====================================================

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // =====================================================
    // INTERNAL
    // =====================================================

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
