package com.apihrutadelvalle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tipo_habitaciones",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Tipo_Habitacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tipo;

	@Column(name="nombre",nullable = false)
	private String nombre;
	
	@Column(name="descripcion",nullable = false)
	private String descripcion;
	
	@Column(name="max_adultos",nullable = false)
	private int max_adultos;
	
	@Column(name="max_ninos",nullable = false)
	private int max_ninos;

	public long getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(long id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getMax_adultos() {
		return max_adultos;
	}

	public void setMax_adultos(int max_adultos) {
		this.max_adultos = max_adultos;
	}

	public int getMax_ninos() {
		return max_ninos;
	}

	public void setMax_ninos(int max_ninos) {
		this.max_ninos = max_ninos;
	}

	public Tipo_Habitacion() {
		super();
	}
	
	
	
	

}
