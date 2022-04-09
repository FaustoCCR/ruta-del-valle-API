package com.apihrutadelvalle.dto;

import java.io.Serializable;
import java.sql.Date;

import com.apihrutadelvalle.entity.Reserva;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ConsumoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id_consumo;
	
	
	private long id_reserva;
	
	private Date fecha;

	public long getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(long id_consumo) {
		this.id_consumo = id_consumo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}
	
	
}
