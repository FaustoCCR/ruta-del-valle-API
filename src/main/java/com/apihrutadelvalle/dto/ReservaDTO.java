package com.apihrutadelvalle.dto;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservaDTO implements Serializable {

	private static final long serialVersionUID = 1L;/*identificar unico por clase*/

	private long id_reserva;
	@NotNull
	private String cliente;
	@NotNull
	private long  id_habitacion;
	
	@Size(min = 0,max = 100, message = "La observacion debe tener de 0 a 100 caracteres")
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
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_ingreso;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_reserva;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_salida;
	

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
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
