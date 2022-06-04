package com.log.app.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

    private static final String secretkey = "mySecretKey";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secretkey).compact();
    }

    
   

    private Claims getClaims(String token) {

        return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
    }

     public String getEmailFromToken(String token) {

        return this.getClaims(token).getSubject();

    }

    public Date getExpirationDateFromToken(String token) {

        return this.getClaims(token).getExpiration();

    }

    public boolean isTokenExpired(String token) {

        return this.getExpirationDateFromToken(token).before(new Date());

    }

    public boolean validateToken(String token, UserDetails userDetails) {

        final String email = getEmailFromToken(token);

        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }
}
