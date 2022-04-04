package com.apihrutadelvalle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "producto",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_producto;

	@Column(name="nombre",nullable = false)
	private String nombre;
	
	@Column(name="descripcion",nullable = false)
	private String descripcion;
	
	@Column(name="precio_venta",nullable = false)
	private double precio_venta;
	
	@Column(name="stock",nullable = false)
	private int stock;

	
	
	public long getId_producto() {
		return id_producto;
	}



	public void setId_producto(long id_producto) {
		this.id_producto = id_producto;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public double getPrecio_venta() {
		return precio_venta;
	}



	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public Producto() {
		super();
	}
	
	
	
	

}
