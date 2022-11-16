package com.bottomline.pmtx.utils;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bottomline.pmtx.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private static String secret = "This_is_secret";
    private static long expiryDuration = 60 * 60;

    public String generateJwt(User user){

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

       
        Claims claims = Jwts.claims()
                .setIssuer(user.toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        
        claims.put("type", user.getRole());
        claims.put("name", user.getName());
        claims.put("id", user.getId());

        
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    public Claims verify(String auth) throws Exception {

        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(auth).getBody();
            return claims;
        } catch(Exception e) {
            throw new AccessDeniedException("Access Denied");
        }
    }



}
