package com.apihrutadelvalle.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Consumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_consumo;
	
	@ManyToOne
    @JoinColumn(name = "FK_id_reserva", nullable = false, updatable = false)
	private long id_reserva;
	
	@Column(name="fecha",nullable = false)
	private Date fecha;

	public long getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(long id_consumo) {
		this.id_consumo = id_consumo;
	}

	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
