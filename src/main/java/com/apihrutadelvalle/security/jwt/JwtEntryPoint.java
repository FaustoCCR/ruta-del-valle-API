package com.apihrutadelvalle.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{
	
	/*Comprueba si existe un Token válido*/
	
	
	/*logger --> nos muestra el estado del método emplementado*/
	private final static Logger LOGGER = LoggerFactory.getLogger(JwtEntryPoint.class);
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		LOGGER.error("fail en el método commence");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"no autorizado");
		
	}
	
	
	

}
