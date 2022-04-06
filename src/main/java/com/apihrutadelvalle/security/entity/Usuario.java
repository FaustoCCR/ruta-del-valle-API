package com.apihrutadelvalle.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	
	@NotNull
	private String dni;
	
	@NotNull
	private String nombre;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	private String telefono;
	
	@NotNull
	@Column(unique = true)
	private String username;
	
	@NotNull
	private String password;
	private boolean estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rol",nullable = false)/*Nombre de la Foreign Key*/
	private Rol rol;

	public Usuario() {
		super();
	}

	public Usuario(@NotNull String dni, @NotNull String nombre, @NotNull String email, @NotNull String telefono,
			@NotNull String username, @NotNull String password, boolean estado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.username = username;
		this.password = password;
		this.estado = estado;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
	
	
	
}
