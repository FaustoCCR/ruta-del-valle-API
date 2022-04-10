package com.apihrutadelvalle.security.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserInformation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*Mostrará información para la vista de algún Usuario*/
	
	private long id_user;
	
	
	@Size(min = 10,max = 10,message = "Cédula debe tener solo 10 caracteres")
	private String dni;
	
	@NotEmpty
	private String nombre;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	private String telefono;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	@NotNull
	private boolean estado;
	@NotNull
	private String rol;

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

}
