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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pago",uniqueConstraints = {@UniqueConstraint(columnNames = {"id_pago"})})
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pago;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", nullable = false)
	private Reserva id_reserva;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consumo", nullable = false)
	private Consumo id_consumo;
	
	@Column(name="fecha_emision")
	@Temporal(TemporalType.DATE)
	private Date fecha_emision;
	
	@Column(name="subtotal",nullable = false)
	private double subtotal;
	
	@Column(name="total_pago",nullable = false)
	private double total_pago;

	
	
	
	public long getId_pago() {
		return id_pago;
	}

	public void setId_pago(long id_pago) {
		this.id_pago = id_pago;
	}

	public Reserva getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Reserva id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Consumo getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(Consumo id_consumo) {
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

	public double getTotal_pago() {
		return total_pago;
	}

	public void setTotal_pago(double total_pago) {
		this.total_pago = total_pago;
	}
	
	
	/*
	 * Enlace con la tabla intermediaria
	 * */
	//@JsonBackReference
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "pago", cascade = CascadeType.ALL)
	//private List<Reserva> listaReserva = new ArrayList<>();
	
	
	
	
	
	
	
	
}
