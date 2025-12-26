package com.example.demo.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    private final String secret = "secret-key";
    private final long validity = 3600000;

    // ✅ REQUIRED: no-arg constructor
    public JwtTokenProvider() {}

    // ✅ REQUIRED by tests
    public String generateToken(Authentication auth) {
        return generateToken(auth, validity, auth.getName(), "USER");
    }

    // ✅ REQUIRED by tests (OVERLOAD)
    public String generateToken(Authentication auth,
                                long userId,
                                String email,
                                String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ REQUIRED
    public Long getUserIdFromToken(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    // ✅ REQUIRED
    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ REQUIRED
    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
