package com.jobs.portal.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Replace this with your secret key
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds



    public static String generateJwtToken(String username,String role,Long id) {
        System.out.println(SECRET_KEY.getEncoded());
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", username);
        claims.put("role",role);
        claims.put("userId",id);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SECRET_KEY)
                .compact();
    }

    public static void decodeJwtToken(String jwtToken) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwtToken)
                .getBody();

        String username = claims.getSubject();
        String role = (String) claims.get("role");

        System.out.println("Username: " + username);
        System.out.println("Role: " + role);
    }
}
