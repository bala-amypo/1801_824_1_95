package com.example.demo.security;

import java.util.Date;
import java.util.Map;

import org.springframework.security.core.Authentication;
import io.jsonwebtoken.*;

public class JwtTokenProvider {

    private final String secret;
    private final long expiry;

    public JwtTokenProvider(String secret, long expiry) {
        this.secret = secret;
        this.expiry = expiry;
    }

    public String generateToken(Authentication auth,
                                Long userId,
                                String email,
                                String role) {

        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .addClaims(Map.of(
                        "email", email,
                        "role", role.replace("ROLE_", "")
                ))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
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

    public String getUserIdFromToken(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
