package com.apihrutadelvalle.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "consumo")
public class Consumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_consumo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", nullable = false)
	private Reserva reserva;
	
	@Column(name="fecha")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	/*
	 * Enlace con la tabla intermediaria
	 * */
	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "consumo", cascade = CascadeType.ALL)
	private List<DetalleConsumo> listaDetalle = new ArrayList<>();
	
	
	public long getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(long id_consumo) {
		this.id_consumo = id_consumo;
	}
	
	@PrePersist 
	public void prePersist() {
		//para adicionar la fecha de creacion
		fecha=new Date();
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
