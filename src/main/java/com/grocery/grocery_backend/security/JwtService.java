package com.grocery.grocery_backend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

@Service
public class JwtService {
	@Value("${jwt.secret}")
	private String secret;
	
	public String generateToken(String email) {
		Key key = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
		
		return Jwts.builder().subject(email).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+ 86400000)).
				signWith(key).compact();
				}


}
