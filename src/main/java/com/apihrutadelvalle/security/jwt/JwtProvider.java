package com.apihrutadelvalle.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.apihrutadelvalle.security.entity.UsuarioPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
	
	/*Genera el Token
	 * Posee un método de validación respecto
	 * a la estructura del Token */
	
	private final static Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);
	
	//hace referencia a las variables definidas en application.properties
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int expiration;
	
	public String generationToken(Authentication authentication) {
		
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
		return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateToken(String token) {
		
		try {
			
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			
			return true;
		} catch (MalformedJwtException e) {
			LOGGER.error("token mal formado");
		} catch (UnsupportedJwtException e) {
			LOGGER.error("token mal no soportado");
		} catch (ExpiredJwtException e) {
			LOGGER.error("token expirado");
		} catch (IllegalArgumentException e) {
			LOGGER.error("token vacío");
		} catch (SignatureException e) {
			LOGGER.error("fallo en la firma");
		}
		
		return false;
		
		
	}
	

}
