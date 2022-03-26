package com.apihrutadelvalle.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.apihrutadelvalle.entity.Planta;
import com.apihrutadelvalle.entity.Tipo_Habitacion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class HabitacionDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id_habitacion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Planta planta;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Tipo_Habitacion tipo_Habitacion;
	
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
	
	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public Tipo_Habitacion getTipo_Habitacion() {
		return tipo_Habitacion;
	}

	public void setTipo_Habitacion(Tipo_Habitacion tipo_Habitacion) {
		this.tipo_Habitacion = tipo_Habitacion;
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

	
	
	
	
}
