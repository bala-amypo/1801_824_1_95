 package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String jwtSecret;
    private final long jwtExpirationMs;

    // REQUIRED by tests
    public JwtTokenProvider(String jwtSecret, long jwtExpirationMs) {
        this.jwtSecret = jwtSecret;
        this.jwtExpirationMs = jwtExpirationMs;
    }

    // Default constructor (Spring)
    public JwtTokenProvider() {
        this.jwtSecret = "test-secret-key";
        this.jwtExpirationMs = 86400000;
    }

    // ================= TOKEN CREATION =================

    // Used by app
    public String generateToken(Authentication authentication,
                                long userId,
                                String email,
                                String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // ✅ REQUIRED by TESTS
    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // ================= TOKEN READ =================

    // ✅ REQUIRED by tests
    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ REQUIRED by tests
    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }

    // ✅ REQUIRED by tests
    public Long getUserIdFromToken(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    // ================= VALIDATION =================

    // ✅ REQUIRED by tests
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // ================= HELPER =================

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }
}
