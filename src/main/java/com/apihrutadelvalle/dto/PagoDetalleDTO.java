package com.apihrutadelvalle.dto;

import java.io.Serializable;
import java.util.Date;

import com.apihrutadelvalle.entity.Reserva;

public class PagoDetalleDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id_pago;
	
	private long reserva_pago;
	
	private long consumo_pago;
	
	private String cliente_pago;
	
	private int num_habitacion;
	
	private double costo_alojamiento;
	
	private Date fecha_emision;
	
	private double subtotal;
	
	private double total_pago;
	
	


	public long getId_pago() {
		return id_pago;
	}




	public void setId_pago(long id_pago) {
		this.id_pago = id_pago;
	}




	



	public long getReserva_pago() {
		return reserva_pago;
	}




	public void setReserva_pago(long reserva_pago) {
		this.reserva_pago = reserva_pago;
	}




	


	public long getConsumo_pago() {
		return consumo_pago;
	}




	public void setConsumo_pago(long consumo_pago) {
		this.consumo_pago = consumo_pago;
	}




	public String getCliente_pago() {
		return cliente_pago;
	}




	public void setCliente_pago(String cliente_pago) {
		this.cliente_pago = cliente_pago;
	}



	public int getNum_habitacion() {
		return num_habitacion;
	}




	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
	}




	public double getCosto_alojamiento() {
		return costo_alojamiento;
	}




	public void setCosto_alojamiento(double costo_alojamiento) {
		this.costo_alojamiento = costo_alojamiento;
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




	public PagoDetalleDTO() {
		super();
	}





	
	
	

}
