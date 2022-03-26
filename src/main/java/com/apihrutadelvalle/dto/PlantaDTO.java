package com.apihrutadelvalle.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import com.apihrutadelvalle.entity.Habitacion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PlantaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id_planta;
	
	@NotEmpty(message = "Ingrese un nombre a la planta")
	private String nombre;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Set<Habitacion> habitaciones = new HashSet<>();

	public Long getId_planta() {
		return id_planta;
	}

	public void setId_planta(Long id_planta) {
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
			

}
