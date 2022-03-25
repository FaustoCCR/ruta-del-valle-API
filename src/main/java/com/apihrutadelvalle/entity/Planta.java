package com.apihrutadelvalle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plantas")
public class Planta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_planta;
	
	private String nombre;

	public long getId_planta() {
		return id_planta;
	}

	public void setId_planta(long id_planta) {
		this.id_planta = id_planta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Planta() {
		super();
	}

	public Planta(long id_planta, String nombre) {
		super();
		this.id_planta = id_planta;
		this.nombre = nombre;
	}
	
	
	

}
