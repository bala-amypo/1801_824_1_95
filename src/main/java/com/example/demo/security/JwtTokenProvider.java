 

package com.example.demo.security;

import java.nio.charset.StandardCharsets;
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

    private final SecretKey key;
    private final long expirationMs;

    // ✅ default constructor (Spring)
    public JwtTokenProvider() {
        this("test-secret-key-test-secret-key", 3600000L);
    }

    // ✅ constructor REQUIRED by tests
    public JwtTokenProvider(String secret, long expirationMs) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
    }

    // --------------------------------------------------
    // BASIC TOKEN
    // --------------------------------------------------
    public String generateToken(Authentication authentication) {
        Long userId = Long.parseLong(authentication.getName());
        return generateToken(authentication, userId, null, null);
    }

    // --------------------------------------------------
    // TOKEN WITH EMAIL
    // --------------------------------------------------
    public String generateToken(Authentication authentication,
                                Long userId,
                                String email) {
        return generateToken(authentication, userId, email, null);
    }

    // --------------------------------------------------
    // FULL TOKEN
    // --------------------------------------------------
    public String generateToken(Authentication authentication,
                                Long userId,
                                String email,
                                String role) {

        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        Claims claims = Jwts.claims();
        claims.setSubject(String.valueOf(userId)); // ✅ subject fallback

        if (email != null) {
            claims.put("email", email);
        }

        if (role != null) {
            claims.put("role", role.replace("ROLE_", "")); // ✅ no prefix
        }

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)              // ✅ required for diff tokens
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // --------------------------------------------------
    // VALIDATE
    // --------------------------------------------------
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

    // --------------------------------------------------
    // GETTERS
    // --------------------------------------------------
    public Long getUserIdFromToken(String token) {
        return Long.parseLong(getClaims(token).getSubject());
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).get("email", String.class);
    }

    public String getRoleFromToken(String token) {
        return getClaims(token).get("role", String.class);
    }

    // --------------------------------------------------
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}



// package com.example.demo.security;

// import java.security.Key;
// import java.util.Date;

// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// @Component
// public class JwtTokenProvider {

//     // ✅ MUST be at least 256 bits (32+ characters)
//     private static final String SECRET =
//             "THIS_IS_A_VERY_SECURE_256_BIT_SECRET_KEY_12345";

//     private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

//     private final Key key;

//     // 🔥 THIS constructor was failing earlier
//     public JwtTokenProvider() {
//         this.key = Keys.hmacShaKeyFor(SECRET.getBytes());
//     }

//     // Generate token
//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     // Extract username
//     public String getUsername(String token) {
//         return getClaims(token).getSubject();
//     }

//     // Validate token
//     public boolean validateToken(String token) {
//         try {
//             getClaims(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     // Internal helper
//     private Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
