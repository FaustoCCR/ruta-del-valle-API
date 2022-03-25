package com.apihrutadelvalle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_habitacion;
	
	/*private int num_habitacion;
	
	/*atributo imagen*/
	
	/*private String estado;
	
	private double costo_noche;*/
	
	/*Relacion Muchos a uno
	 * Muchos habitaciones pueden pertenecer a un tipo
	 * */
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo",nullable = false)/*Nombre de la Foreign Key*/
	
	
	
	
	
	
}
