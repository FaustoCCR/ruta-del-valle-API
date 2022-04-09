package com.apihrutadelvalle.dto;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReservaDTO implements Serializable {

	private static final long serialVersionUID = 1L;/*identificar unico por clase*/

	private long id_reserva;
	@NotNull
	private long id_usuario;
	@NotNull
	private long  id_habitacion;
	
	@NotEmpty
	@Size(min = 0,max = 100, message = "La observacion es demasiado grande")
	private String observaciones;
	
	@NotEmpty
	@Size(min = 2, max = 50,message = "Ingresa el estado de la reserva")
	private String estado;
	
	@Min(1)
	private int adultos;

	@Min(0)
	private int ninos;
	
	@Min(0)
	private double costo_alojamiento;
	
	@NotNull
	private Date fecha_ingreso;
	private Date fecha_reserva;
	@NotNull
	private Date fecha_salida;
	
	
	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public long  getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(long habitacion) {
		this.id_habitacion = habitacion;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	public double getCosto_alojamiento() {
		return costo_alojamiento;
	}

	public void setCosto_alojamiento(double costo_alojamiento) {
		this.costo_alojamiento = costo_alojamiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
