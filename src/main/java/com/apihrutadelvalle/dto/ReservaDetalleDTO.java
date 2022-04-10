package com.apihrutadelvalle.dto;

import java.io.Serializable;
import java.util.Date;

public class ReservaDetalleDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id_reserva;
	
	private String cliente;
	
	private int num_habitacion;
	
	private String tipo_habitacion;
	
	private String descripcion;
	
	private String planta;
	
	private String estado;
	
	private int adultos;
	
	private int ninos;
	
	private Date fecha_reserva;
	
	private Date fecha_ingreso;
	
	private Date fecha_salida;
	
	private double precio_noche;
	
	private double costo_alojamiento;
	
	private String observaciones;


	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNum_habitacion() {
		return num_habitacion;
	}

	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
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

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getAdultos() {
		return adultos;
	}

	public void setAdultos(int adultos) {
		this.adultos = adultos;
	}

	public int getNinos() {
		return ninos;
	}

	public void setNinos(int ninos) {
		this.ninos = ninos;
	}
	
	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	
	public double getPrecio_noche() {
		return precio_noche;
	}

	public void setPrecio_noche(double precio_noche) {
		this.precio_noche = precio_noche;
	}

	public double getCosto_alojamiento() {
		return costo_alojamiento;
	}

	public void setCosto_alojamiento(double costo_alojamiento) {
		this.costo_alojamiento = costo_alojamiento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

	
	
	
	

}
