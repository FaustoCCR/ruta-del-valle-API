package com.apihrutadelvalle.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pagos")
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pago;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_reserva", nullable = false, referencedColumnName = "id_reserva", unique = true)
	private Reserva reserva;
	
	@Column(name="fecha_emision",nullable = false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	Date fecha_emision;
	
	@Column(name = "subtotal")
	double subtotal;
	
	@Column(name="total_pago",nullable = false)
	double total_pago;
	

	
	@PrePersist 
	public void prePersist() {
		//para adicionar la fecha de creacion
		fecha_emision=new Date();
	}


	public long getId_pago() {
		return id_pago;
	}


	public void setId_pago(long id_pago) {
		this.id_pago = id_pago;
	}


	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
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
	
	
	public List<Reserva> getinfoReserva(){
		List<Reserva> reservas = new ArrayList<>();
		
		reservas.add(reserva);
		return reservas;
		
	}

}
