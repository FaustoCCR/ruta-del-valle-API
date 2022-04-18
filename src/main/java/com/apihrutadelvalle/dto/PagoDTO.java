package com.apihrutadelvalle.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PagoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id_pago;
	
	private long id_reserva;
	@NotNull
	
	private long id_consumo;
	@NotNull
	
	
	@Temporal(TemporalType.DATE)
	private Date fecha_emision;
	
	
	private double subtotal;
	
	private double pago_total;

	public long getId_pago() {
		return id_pago;
	}

	public void setId_pago(long id_pago) {
		this.id_pago = id_pago;
	}

	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public long getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(long id_consumo) {
		this.id_consumo = id_consumo;
	}

	public Date getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getPago_total() {
		return pago_total;
	}

	public void setPago_total(double pago_total) {
		this.pago_total = pago_total;
	}
	
	
	
	
	
	
	
}
