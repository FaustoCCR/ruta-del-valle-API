package com.apihrutadelvalle.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ConsumoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id_consumo;
	
	private long id_reserva;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private List<DetalleConsumoDTO> listaDetalle = new ArrayList<>();
	
	private double total_consumido;
	
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

	public List<DetalleConsumoDTO> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<DetalleConsumoDTO> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	public double getTotal_consumido() {
		return total_consumido;
	}

	public void setTotal_consumido(double total_consumido) {
		this.total_consumido = total_consumido;
	}
	
	
	
	
	
	
}
