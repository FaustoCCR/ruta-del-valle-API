package com.apihrutadelvalle.security.entity;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails{
	
	/*Clase encargada de la seguridad
	 * Identifica los privilegios*/
	
	private String dni;
	
	private String nombre;
	
	private String email;
	
	private String telefono;
	
	private String username;
	
	private String password;
	
	private boolean estado;
	
	private GrantedAuthority authorities;
	

	public UsuarioPrincipal(String dni, String nombre, String email, String telefono, String username, String password,
			boolean estado, GrantedAuthority authorities) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.username = username;
		this.password = password;
		this.estado = estado;
		this.authorities = authorities;
	}

	/*Asignamos los privilegios*/
	public static UsuarioPrincipal build(Usuario usuario) {
		GrantedAuthority authorities = new SimpleGrantedAuthority(usuario.getRol().getNombre().name());
		
		
		return new UsuarioPrincipal(usuario.getDni(), usuario.getNombre(), usuario.getEmail(), usuario.getTelefono(), usuario.getUsername(), usuario.getPassword(), usuario.isEstado(), authorities);
				
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
