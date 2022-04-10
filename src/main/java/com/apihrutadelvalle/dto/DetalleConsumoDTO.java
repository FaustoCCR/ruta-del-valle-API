package com.apihrutadelvalle.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;

public class DetalleConsumoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id_dtconsumo;
	
	private long id_consumo;
	
	private String producto;
	
	@Min(1)
	private int cantidad;
	
	double precio_total;

	public long getId_dtconsumo() {
		return id_dtconsumo;
	}

	public void setId_dtconsumo(long id_dtconsumo) {
		this.id_dtconsumo = id_dtconsumo;
	}


	public long getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(long id_consumo) {
		this.id_consumo = id_consumo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
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
	
	
	
}
