package com.shubham.projects.journal.Configration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.sql.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String rawSecret;

    private Key getSECRET() {
        return Keys.hmacShaKeyFor(rawSecret.getBytes());
    }



    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new java.util.Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hrs
                .signWith(SignatureAlgorithm.HS256, getSECRET())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(getSECRET())
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername());
    }
}

