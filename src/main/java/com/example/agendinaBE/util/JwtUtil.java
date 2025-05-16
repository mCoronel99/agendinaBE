package com.example.agendinaBE.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secretKeyString = "your-super-secure-key-your-super-secure-key"; // Deve essere lungo almeno 32 byte
    private final SecretKey secretKey = Keys.hmacShaKeyFor(secretKeyString.getBytes(StandardCharsets.UTF_8));

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
    
        // Estrai i ruoli come stringa separata da virgole
        String roles = authentication.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .reduce((a, b) -> a + "," + b)
                .orElse("");
    
        Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10); // 10 ore
    
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
    

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String getUsername(String token) {
        return extractClaims(token).getSubject();
    }
    
    public String[] getRoles(String token) {
        String roles = extractClaims(token).get("roles", String.class);
        return roles != null ? roles.split(",") : new String[0];
    }
}
