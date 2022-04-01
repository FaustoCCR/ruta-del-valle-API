package com.apihrutadelvalle.security.dto;

import javax.validation.constraints.NotNull;

public class LoginUsuario {
	
	//Clase para el acceso al aplicativo
	//incluye los datos primordiales
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
