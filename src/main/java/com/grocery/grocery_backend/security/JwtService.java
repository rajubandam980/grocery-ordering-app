package com.grocery.grocery_backend.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    private Key getKey() {

        return new SecretKeySpec(
                secret.getBytes(),
                SignatureAlgorithm.HS256.getJcaName());
    }

    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis()
                                + 86400000))
                .signWith(getKey())
                .compact();
    }

    public String extractEmail(String token) {

        Claims claims =
                Jwts.parser()
                        .verifyWith(
                                (javax.crypto.SecretKey) getKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {

        try {

            Jwts.parser()
                    .verifyWith(
                            (javax.crypto.SecretKey) getKey())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception ex) {

            return false;
        }
    }
}