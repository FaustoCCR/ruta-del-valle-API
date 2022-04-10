package com.apihrutadelvalle.security.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.apihrutadelvalle.security.enums.RolNombre;

@Entity
@Table(name = "roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_rol;
	
	@NotNull
	@Enumerated(EnumType.STRING)/*Indica que es enumerado el campo*/
	private RolNombre nombre;

	public Rol() {
		super();
	}

	public Rol(@NotNull RolNombre nombre) {
		super();
		this.nombre = nombre;
	}

	public long getId_rol() {
		return id_rol;
	}

	public void setId_rol(long id_rol) {
		this.id_rol = id_rol;
	}

	public RolNombre getNombre() {
		return nombre;
	}

	public void setNombre(RolNombre nombre) {
		this.nombre = nombre;
	}
	
	
}
