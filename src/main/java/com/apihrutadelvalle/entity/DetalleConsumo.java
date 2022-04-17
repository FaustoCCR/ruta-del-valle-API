package com.apihrutadelvalle.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_consumo")
public class DetalleConsumo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_dtconsumo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_consumo",nullable = false)
	private Consumo consumo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_producto",nullable = false)
	private Producto producto;
	
	int cantidad;
	
	double precio_total;

	public long getId_dtconsumo() {
		return id_dtconsumo;
	}

	public void setId_dtconsumo(long id_dtconsumo) {
		this.id_dtconsumo = id_dtconsumo;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
	
	
	/*
	 * Jasper*/
	
	public String getNombre_producto() {
		return producto.getNombre();
	}
	
	public double getPrecio_venta() {
		 return producto.getPrecio_venta();
	}
	
	
	
	

}
