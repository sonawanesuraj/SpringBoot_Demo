package com.demo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.ServiceImpl.AuthServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	
	
	@Autowired
AuthServiceImpl authServiceImpl;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// get token

	final	String requestToken = request.getHeader("Authorization");

		// Bearer

		System.out.println(requestToken);

		String email = null;

		String token = null;
		

		if (requestToken != null && requestToken.startsWith("Bearer ")) {
			token = requestToken.substring(7);
			System.out.println(requestToken.substring(7));
			try {
			
				email=jwtTokenUtil.getEmailFromToken(token);
			//	System.out.println(jwtTokenUtil.getEmailFromToken(token));
				
			} catch (IllegalArgumentException e) 
			{
				System.out.println("Unable to get Jwt token..");
				
			} 
			catch (ExpiredJwtException e) {
				
				System.out.println("Jwt token has Expired..");
			}
			catch(IllegalStateException e)
			{
			System.out.println("Can not convert to json..");
			}
			catch(NullPointerException e)
			{
				System.out.println("Null value not allowed..");
			}
		
		}
		 else {
			
              logger.warn("Jwt  token not start with  bearer ");
		 }

		// once we get the token , now validate

		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			//UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
			UserDetails userDetails = this.authServiceImpl.loadUserByUserName(email);
			
			if (this.jwtTokenUtil.validateToken(token, userDetails)) {	
				
UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

		
			}
			}
		    filterChain.doFilter(request, response);

	
	}

}
