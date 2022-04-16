package com.apihrutadelvalle.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PagoDetalleDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id_pago;
	private long id_reserva;
	private String Cliente;
	
	
	/*habitacion*/
	private int num_habitacion;
	private String tipo_habitacion;
	private String planta;
	
	/**/
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_emision;
	
	private double pago_consumo;
	
	private double pago_alojamiento;
	
	private double subtotal;
	
	private double total;

	public long getId_pago() {
		return id_pago;
	}

	public void setId_pago(long id_pago) {
		this.id_pago = id_pago;
	}

	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getCliente() {
		return Cliente;
	}

	public void setCliente(String cliente) {
		Cliente = cliente;
	}

	public int getNum_habitacion() {
		return num_habitacion;
	}

	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
	}

	public String getTipo_habitacion() {
		return tipo_habitacion;
	}

	public void setTipo_habitacion(String tipo_habitacion) {
		this.tipo_habitacion = tipo_habitacion;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public Date getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public double getPago_consumo() {
		return pago_consumo;
	}

	public void setPago_consumo(double pago_consumo) {
		this.pago_consumo = pago_consumo;
	}

	public double getPago_alojamiento() {
		return pago_alojamiento;
	}

	public void setPago_alojamiento(double pago_alojamiento) {
		this.pago_alojamiento = pago_alojamiento;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	
	

}
