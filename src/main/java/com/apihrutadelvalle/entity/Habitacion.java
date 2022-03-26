package com.apihrutadelvalle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "habitaciones",uniqueConstraints = {@UniqueConstraint(columnNames = {"num_habitacion"})})
public class Habitacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_habitacion;
	
	@Column(name="num_habitacion",nullable = false)
	private int num_habitacion;
	
	/*atributo imagen*/
	
	@Column(name="estado",nullable = false)
	private String estado;
	
	@Column(name="costo_noche",nullable = false)
	private double costo_noche;
	
	/*Relacion Muchos a uno
	 * Muchos habitaciones pueden pertenecer a un tipo
	 * */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo",nullable = false)/*Nombre de la Foreign Key*/
	private Tipo_Habitacion tipo_Habitacion;
	
	/*Relacion Muchos a uno
	 * Muchas habitaciones pueden estar en una planta
	 * */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_planta",nullable = false)/*Nombre de la Foreign Key*/
	private Planta planta;

	public long getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(long id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public int getNum_habitacion() {
		return num_habitacion;
	}

	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getCosto_noche() {
		return costo_noche;
	}

	public void setCosto_noche(double costo_noche) {
		this.costo_noche = costo_noche;
	}

	public Tipo_Habitacion getTipo_Habitacion() {
		return tipo_Habitacion;
	}

	public void setTipo_Habitacion(Tipo_Habitacion tipo_Habitacion) {
		this.tipo_Habitacion = tipo_Habitacion;
	}

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public Habitacion() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
}
