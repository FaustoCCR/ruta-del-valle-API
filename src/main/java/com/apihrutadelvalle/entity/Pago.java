package com.apihrutadelvalle.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

<<<<<<< HEAD
import javax.persistence.CascadeType;
=======
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
<<<<<<< HEAD
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
=======
import javax.persistence.OneToOne;
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
<<<<<<< HEAD
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pago",uniqueConstraints = {@UniqueConstraint(columnNames = {"id_pago"})})
=======

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pagos")
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pago;
	
<<<<<<< HEAD
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

	
	
	
=======
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


>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public long getId_pago() {
		return id_pago;
	}

<<<<<<< HEAD
=======

>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public void setId_pago(long id_pago) {
		this.id_pago = id_pago;
	}

<<<<<<< HEAD
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

=======

	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public Date getFecha_emision() {
		return fecha_emision;
	}

<<<<<<< HEAD
=======

>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

<<<<<<< HEAD
=======

>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public double getSubtotal() {
		return subtotal;
	}

<<<<<<< HEAD
=======

>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

<<<<<<< HEAD
=======

>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public double getTotal_pago() {
		return total_pago;
	}

<<<<<<< HEAD
=======

>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public void setTotal_pago(double total_pago) {
		this.total_pago = total_pago;
	}
	
	
<<<<<<< HEAD
	/*
	 * Enlace con la tabla intermediaria
	 * */
	//@JsonBackReference
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "pago", cascade = CascadeType.ALL)
	//private List<Reserva> listaReserva = new ArrayList<>();
	
	
	
	
	
	
	
	
=======
	public List<Reserva> getinfoReserva(){
		List<Reserva> reservas = new ArrayList<>();
		
		reservas.add(reserva);
		return reservas;
		
	}

>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
}
