package com.apihrutadelvalle.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
public class TipoHabitacionDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id_tipo;
	
	@NotEmpty
	@Size(min = 2, message = "El nombre debería tener al menos dos caracteres")
	private String nombre;
	
	@NotEmpty
	@Size(min = 10, max = 255,message = "La descripción debería tener entre 10 a 255 caracteres")
	private String descripcion;
	
	@Min(0)
	private int max_adultos;

	@Min(0)
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
	
	
	
	
	
	
	

}
