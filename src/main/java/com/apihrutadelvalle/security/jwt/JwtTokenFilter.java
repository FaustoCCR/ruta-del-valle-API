package com.apihrutadelvalle.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.apihrutadelvalle.security.service.UserDetailsServiceImpl;

public class JwtTokenFilter extends OncePerRequestFilter{
	
	/*
	 * Se ejecuta por cada petición,
	 * permite acceder a los recursos*/
	
	private final static Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);
	
	@Autowired
	JwtProvider jwtProvider;
	
	//servicio
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			
			String token = getToken(request);
			if (token != null && jwtProvider.validateToken(token)) {
				
				String username = jwtProvider.getUsernameFromToken(token);
				UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken auth = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(auth);
				
			}
		} catch (Exception e) {
			LOGGER.error("fail el método doFilterInternal" + e.getMessage());
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	//Extraer el token
	private String getToken(HttpServletRequest request) {
		
		String header = request.getHeader("Authorization");
		if (header!=null && header.startsWith("Bearer")) {
			
			return header.replace("Bearer", "");
		}else {
			return null;
		}
	}

}
