//     package com.example.demo.security;

// import java.util.Date;

// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// @Component
// public class JwtTokenProvider {

//     private final String secretKey;
//     private final long validityInMs;

//     // ✅ REQUIRED BY TESTS
//     public JwtTokenProvider(String secretKey, long validityInMs) {
//         this.secretKey = secretKey;
//         this.validityInMs = validityInMs;
//     }

//     // ✅ REQUIRED BY SPRING
//     public JwtTokenProvider() {
//         this.secretKey = "test-secret";
//         this.validityInMs = 3600000;
//     }

//     // =========================
//     // TOKEN GENERATION
//     // =========================

//     // ✅ used by basic tests
//     public String generateToken(Authentication authentication) {
//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + validityInMs);

//         return Jwts.builder()
//                 .setSubject(authentication.getName())
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(SignatureAlgorithm.HS256, secretKey)
//                 .compact();
//     }

//     // ✅ REQUIRED BY JWT CLAIM TESTS
//     public String generateToken(Authentication authentication,
//                                 long userId,
//                                 String email,
//                                 String role) {

//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + validityInMs);

//         return Jwts.builder()
//                 .setSubject(String.valueOf(userId))
//                 .claim("email", email)
//                 .claim("role", role)
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(SignatureAlgorithm.HS256, secretKey)
//                 .compact();
//     }

//     // =========================
//     // TOKEN READERS
//     // =========================

//     public Long getUserIdFromToken(String token) {
//         Claims claims = parseClaims(token);
//         return Long.parseLong(claims.getSubject());
//     }

//     public String getEmailFromToken(String token) {
//         Claims claims = parseClaims(token);
//         return claims.get("email", String.class);
//     }

//     public String getRoleFromToken(String token) {
//         Claims claims = parseClaims(token);
//         return claims.get("role", String.class);
//     }

//     // =========================
//     // VALIDATION
//     // =========================

//     public boolean validateToken(String token) {
//         try {
//             parseClaims(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     // =========================
//     // INTERNAL
//     // =========================

//     private Claims parseClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secretKey)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
// package com.example.demo.security;

// import java.util.Date;

// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// @Component
// public class JwtTokenProvider {

//     private final String secretKey;
//     private final long validityInMs;

//     // ✅ Constructor used by tests
//     public JwtTokenProvider(String secretKey, long validityInMs) {
//         this.secretKey = secretKey;
//         this.validityInMs = validityInMs;
//     }

//     // ✅ Default constructor
//     public JwtTokenProvider() {
//         this.secretKey = "test-secret-key";
//         this.validityInMs = 3600000;
//     }

//     // =========================
//     // TOKEN GENERATION
//     // =========================

//     // ❗ DO NOT use username here
//     public String generateToken(Authentication authentication) {
//         return generateToken(authentication, 0L, null, null);
//     }

//     // ✅ MAIN method expected by tests
//     public String generateToken(Authentication authentication,
//                                 long userId,
//                                 String email,
//                                 String role) {

//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + validityInMs);

//         return Jwts.builder()
//                 // ✅ subject MUST be userId
//                 .setSubject(userId > 0 ? String.valueOf(userId) : authentication.getName())
//                 .claim("email", email)
//                 .claim("role", role) // ❌ NO ROLE_ PREFIX
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(SignatureAlgorithm.HS256, secretKey)
//                 .compact();
//     }

//     // =========================
//     // CLAIM READERS
//     // =========================

//     public Long getUserIdFromToken(String token) {
//         return Long.parseLong(parseClaims(token).getSubject());
//     }

//     public String getEmailFromToken(String token) {
//         return parseClaims(token).get("email", String.class);
//     }

//     public String getRoleFromToken(String token) {
//         return parseClaims(token).get("role", String.class);
//     }

//     // =========================
//     // VALIDATION
//     // =========================

//     public boolean validateToken(String token) {
//         try {
//             parseClaims(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     // =========================
//     // INTERNAL
//     // =========================

//     private Claims parseClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secretKey)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }



package com.example.demo.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    private String secretKey;
    private long expirationMs;

    // ✅ Spring constructor
    public JwtTokenProvider() {
        this.secretKey = "test-secret";
        this.expirationMs = 3600000;
    }

    // ✅ TEST constructor
    public JwtTokenProvider(String secretKey, long expirationMs) {
        this.secretKey = secretKey;
        this.expirationMs = expirationMs;
    }

    // ------------------------------------------------
    // BASIC TOKEN (tests call this)
    // ------------------------------------------------
    public String generateToken(Authentication authentication) {
        Long userId = Long.parseLong(authentication.getName());
        return generateToken(authentication, userId, null, null);
    }

    // ------------------------------------------------
    // TOKEN WITH USER ID + EMAIL
    // ------------------------------------------------
    public String generateToken(Authentication authentication,
                                Long userId,
                                String email) {
        return generateToken(authentication, userId, email, null);
    }

    // ------------------------------------------------
    // FULL TOKEN (MAIN)
    // ------------------------------------------------
    public String generateToken(Authentication authentication,
                                Long userId,
                                String email,
                                String role) {

        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        Claims claims = Jwts.claims();
        claims.setSubject(String.valueOf(userId)); // ✅ subject = userId

        if (email != null) {
            claims.put("email", email);
        }

        if (role != null) {
            claims.put("role", role.replace("ROLE_", "")); // ✅ no prefix
        }

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // ------------------------------------------------
    // VALIDATE
    // ------------------------------------------------
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ------------------------------------------------
    // GET USER ID (FROM SUBJECT)
    // ------------------------------------------------
    public Long getUserIdFromToken(String token) {
        Claims claims = parse(token);
        return Long.parseLong(claims.getSubject());
    }

    // ------------------------------------------------
    // GET EMAIL
    // ------------------------------------------------
    public String getEmailFromToken(String token) {
        return parse(token).get("email", String.class);
    }

    // ------------------------------------------------
    // GET ROLE
    // ------------------------------------------------
    public String getRoleFromToken(String token) {
        return parse(token).get("role", String.class);
    }

    // ------------------------------------------------
    // INTERNAL PARSER
    // ------------------------------------------------
    private Claims parse(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
