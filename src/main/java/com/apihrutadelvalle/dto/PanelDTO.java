package com.apihrutadelvalle.dto;

import java.io.Serializable;
import java.util.List;

public class PanelDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int hb_disponibles;
	
	private int hb_reservadas;
	
	private int hb_ocupadas;
	
	private List<PagoDetalleDTO> pagos;

	public int getHb_disponibles() {
		return hb_disponibles;
	}

	public void setHb_disponibles(int hb_disponibles) {
		this.hb_disponibles = hb_disponibles;
	}

	public int getHb_reservadas() {
		return hb_reservadas;
	}

	public void setHb_reservadas(int hb_reservadas) {
		this.hb_reservadas = hb_reservadas;
	}

	public int getHb_ocupadas() {
		return hb_ocupadas;
	}

	public void setHb_ocupadas(int hb_ocupadas) {
		this.hb_ocupadas = hb_ocupadas;
	}

	public List<PagoDetalleDTO> getPagos() {
		return pagos;
	}

	public void setPagos(List<PagoDetalleDTO> pagos) {
		this.pagos = pagos;
	}
	
	
	
	

}
