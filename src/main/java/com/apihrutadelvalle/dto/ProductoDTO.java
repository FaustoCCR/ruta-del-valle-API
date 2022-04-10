package com.apihrutadelvalle.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
public class ProductoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id_producto;
	
	@NotEmpty
	@Size(min = 2, message = "El nombre debería tener al menos dos caracteres")
	private String nombre;
	
	@NotEmpty
	@Size(min = 10, max = 255,message = "La descripción debería tener entre 10 a 255 caracteres")
	private String descripcion;
	
	@Min(0)
	private double precio_venta;public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}
	@Min(0)
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


	
	
	
	
	
	
	
	

}
