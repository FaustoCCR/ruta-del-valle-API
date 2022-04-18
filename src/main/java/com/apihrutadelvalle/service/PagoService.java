package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PagoDTO;

public interface PagoService {
	
	public PagoDetalleDTO obtenerPagoId(long id_pago);
	
	public List<PagoDetalleDTO> obtenerPago();
	
	public PagoDetalleDTO obtenerPagoPorReserva(long id_reserva);
	
	public PagoDTO crearPago(long id_reserva, long id_consumo, PagoDTO pagoDTO);
	
	public PagoDTO actualizarPago(PagoDTO pagoDTO, long id_pago, long id_reserva, long id_consumo);
	
	public void eliminarPago (long id_pago);
}
