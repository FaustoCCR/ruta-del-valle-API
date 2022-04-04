package com.apihrutadelvalle.dto;

import java.io.Serializable;

public class ConsumoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id_consumo;
	
	private long id_reserva;
	
	private long id_producto;
	
	private int cantidad;
	
	private double precio_total;

	public long getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(long id_consumo) {
		this.id_consumo = id_consumo;
	}

	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public long getId_producto() {
		return id_producto;
	}

	public void setId_producto(long id_producto) {
		this.id_producto = id_producto;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
