package com.example.demo.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    // 🔥 TESTS REQUIRE NO-ARG CONSTRUCTOR
    public JwtTokenProvider() {}

    private final String SECRET = "test-secret-key";
    private final long EXPIRATION = 86400000;

    // ================= REQUIRED OVERLOADS =================

    // ✔ used in many tests
    public String generateToken(Authentication auth,
                                Long userId,
                                String role) {
        return buildToken(auth.getName(), userId, role);
    }

    // ✔ used in jwtDifferentIds test
    public String generateToken(Authentication auth,
                                long userId,
                                String role,
                                String email) {
        return buildToken(email, userId, role);
    }

    // ✔ used in fallback tests
    public String generateToken(Authentication auth,
                                long userId,
                                String role) {
        return buildToken(auth.getName(), userId, role);
    }

    // ================= TOKEN READ =================

    public Long getUserIdFromToken(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }

    // ================= VALIDATION =================

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ================= INTERNAL =================

    private String buildToken(String email, Long userId, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
