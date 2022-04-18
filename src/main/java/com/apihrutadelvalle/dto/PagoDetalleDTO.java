package com.apihrutadelvalle.dto;

import java.io.Serializable;
import java.util.Date;

<<<<<<< HEAD
import com.apihrutadelvalle.entity.Reserva;
=======
import com.fasterxml.jackson.annotation.JsonFormat;
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1

public class PagoDetalleDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD

	private long id_pago;
	
	private long reserva_pago;
	
	private long consumo_pago;
	
	private String cliente_pago;
	
	private int num_habitacion;
	
	private double costo_alojamiento;
	
	private Date fecha_emision;
	
	private double subtotal;
	
	private double total_pago;
	
	

=======
	
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



=======
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

>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public int getNum_habitacion() {
		return num_habitacion;
	}

<<<<<<< HEAD



=======
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
	}

<<<<<<< HEAD



	public double getCosto_alojamiento() {
		return costo_alojamiento;
	}




	public void setCosto_alojamiento(double costo_alojamiento) {
		this.costo_alojamiento = costo_alojamiento;
	}



=======
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



	public double getTotal_pago() {
		return total_pago;
	}




	public void setTotal_pago(double total_pago) {
		this.total_pago = total_pago;
	}




	public PagoDetalleDTO() {
		super();
	}





=======
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	
	
	

}
