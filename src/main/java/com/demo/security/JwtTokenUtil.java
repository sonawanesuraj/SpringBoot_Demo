package com.demo.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.demo.entity.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil  {
	
	public static final long JWT_TOKEN_VALIDITY =5 * 60 * 1000;
	
	private String secreteKey = "jwtTokenKey";
	
	
	//retriew username from jwt token 
	// retrieve username from jwt token
	public String getEmailFromToken(String token) {

		return getClaimFromToken(token, Claims::getSubject);

	}
	
	public String getUsernameFromToken(String token){
		
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	
	// expiration date from jwt token 
	public Date getExpirationDateFromToken(String token) {
		
		return getClaimFromToken(token,Claims::getExpiration) ;
		
	}
	
	public <T> T getClaimFromToken(String token,Function<Claims,T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}


	private Claims getAllClaimsFromToken(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser()
			    .setSigningKey(secreteKey)
			    .parseClaimsJws(token)
			    .getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token); 
		return expiration.before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims,userDetails.getUsername()); 
			
		}
	 private String createToken(Map<String, Object> claims, String subject) {
		 System.out.println(System.currentTimeMillis()+ JWT_TOKEN_VALIDITY);
	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
	                .signWith(SignatureAlgorithm.HS256, secreteKey).compact();
	    }

	
	 // validate token 
	public boolean validateToken(String token , UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	

}
