package com.apihrutadelvalle.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "consumo")
public class Consumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_consumo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", nullable = false)
	private Reserva reserva;
	
	@Column(name="fecha",nullable = false)
	private Date fecha;
	
	
	/*
	 * Enlace con la tabla intermediaria
	 * */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "consumo")
	private List<DetalleConsumo> listaDetalle = new ArrayList<>();
	
	
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

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<DetalleConsumo> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<DetalleConsumo> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	
	
	
	
	
	
}
