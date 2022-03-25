package com.apihrutadelvalle.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "plantas",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Planta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_planta;
	
	@Column(name="nombre",nullable = false)
	private String nombre;
	
	/*@JsonBackReference --> permite mejor flujo de datos entre json*/
	
	/*OneToMany --> una Planta puede ser asignada a muchas habitaciones*/
	@JsonBackReference
	@OneToMany(mappedBy = "planta",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Habitacion> habitaciones = new HashSet<>();

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
	

	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
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
