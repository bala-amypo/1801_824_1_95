 package com.example.demo.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    private final String secretKey;
    private final long validityInMs;

    // ✅ REQUIRED BY TESTS
    public JwtTokenProvider(String secretKey, long validityInMs) {
        this.secretKey = secretKey;
        this.validityInMs = validityInMs;
    }

    // ✅ REQUIRED DEFAULT CONSTRUCTOR (Spring)
    public JwtTokenProvider() {
        this.secretKey = "test-secret";
        this.validityInMs = 3600000;
    }

    // ✅ REQUIRED BY TESTS
    public String generateToken(Authentication authentication) {
        String userId = authentication.getName();

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // ✅ REQUIRED BY TESTS
    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // ✅ REQUIRED BY TESTS
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
