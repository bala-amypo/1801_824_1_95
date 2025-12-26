package com.example.demo.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Component
public class JwtTokenProvider {

    // ===== REQUIRED FIELDS =====
    private String secretKey;
    private long expirationMs;
    private SecretKey key;

    // ===== NO-ARG CONSTRUCTOR (Spring) =====
    public JwtTokenProvider() {
        this.secretKey = "defaultSecretKeyForTests1234567890";
        this.expirationMs = 86400000; // 1 day
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // ===== CONSTRUCTOR REQUIRED BY TEST =====
    public JwtTokenProvider(String secretKey, long expirationMs) {
        this.secretKey = secretKey;
        this.expirationMs = expirationMs;
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // ===== GENERATE TOKEN (used by tests) =====
    public String generateToken(Long userId, String email, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ===== OVERLOADED (Spring Security Authentication) =====
    public String generateToken(Authentication authentication, Long userId, String role) {
        String email = authentication.getName();
        return generateToken(userId, email, role);
    }

    // ===== READ EMAIL =====
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // ===== READ ROLE =====
    public String getRoleFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("role", String.class);
    }

    // ===== VALIDATE TOKEN =====
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
