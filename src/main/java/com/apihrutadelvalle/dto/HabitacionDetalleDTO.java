package com.apihrutadelvalle.dto;

import java.io.Serializable;

public class HabitacionDetalleDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id_habitacion;
	
	private int num_habitacion;
	
	private String planta;
	
	private String tipo_habitacion;
	
	private String descripcion;
	
	private int max_adultos;
	
	private int max_ninos;
	
	/*fotografía*/
	
	private String estado;
	
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

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getTipo_habitacion() {
		return tipo_habitacion;
	}

	public void setTipo_habitacion(String tipo_habitacion) {
		this.tipo_habitacion = tipo_habitacion;
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
	
	

	public HabitacionDetalleDTO() {
		super();
	}
	
	

}
