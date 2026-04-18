package com.capg.springboot.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    // Convert secret String → Key object
    // Done once here, reused in all methods below
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    // ─── GENERATE TOKEN ───
    // Long userId converted to String using String.valueOf()
    // setSubject() ONLY accepts String — this is JWT specification rule
    // JWT subject is always stored as String internally anyway
    public String generateToken(Long userId, String role) {
        return Jwts.builder()
            .setSubject(String.valueOf(userId))  // ✅ Long → String conversion
            .claim("role", role)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey())
            .compact();
    }

    // ─── VALIDATE TOKEN ───
    // Returns true if token is valid, false if expired or tampered
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    // ─── GET userId FROM TOKEN ───
    // getSubject() returns String
    // We convert back to Long using Long.valueOf()
    // because your userId field is Long type
    public Long getUserIdFromToken(String token) {
        String subject = Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();

        return Long.valueOf(subject);  // ✅ String → Long conversion back
    }

    // ─── GET role FROM TOKEN ───
    public String getRoleFromToken(String token) {
        return (String) Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody()
            .get("role");
    }
}