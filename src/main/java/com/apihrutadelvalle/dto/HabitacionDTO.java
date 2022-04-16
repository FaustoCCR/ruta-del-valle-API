package com.apihrutadelvalle.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


public class HabitacionDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id_habitacion;
	
	private String nombrePlanta;
	
	private String nombreTipo;
	
	@Min(1)
	private int num_habitacion;
	
	/*fotografía*/
	
	@NotEmpty(message = "Ingresa el estado de la habitación")
	private String estado;
	
	@Min(0)
	private double costo_noche;

	public long getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(long id_habitacion) {
		this.id_habitacion = id_habitacion;
	}
	
	public int getNum_habitacion() {
		return num_habitacion;
	}

	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getCosto_noche() {
		return costo_noche;
	}

	public void setCosto_noche(double costo_noche) {
		this.costo_noche = costo_noche;
	}

	public HabitacionDTO() {
		super();
	}

	public String getNombrePlanta() {
		return nombrePlanta;
	}
	

	public void setNombrePlanta(String nombrePlanta) {
		this.nombrePlanta = nombrePlanta;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
