package com.apihrutadelvalle.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDto {
	
	//Al momento de hacer un login nos devuelve el token
	
	private String token;
	
	private String bearer = "Bearer";
	
	private String username;
	
	private Collection<? extends GrantedAuthority> authorities;

	/*public JwtDto(String token, String username, GrantedAuthority authority) {
		super();
		this.token = token;
		this.username = username;
		this.authority = authority;
	}*/
	

	public String getToken() {
		return token;
	}

	public JwtDto(String token, String username, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.token = token;
		this.username = username;
		this.authorities = authorities;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	


	
	
	

}
