package com.apihrutadelvalle.service;

import java.util.List;

<<<<<<< HEAD
import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PagoDTO;

public interface PagoService {
	
	public PagoDetalleDTO obtenerPagoId(long id_pago);
	
	public List<PagoDetalleDTO> obtenerPago();
	
	public PagoDetalleDTO obtenerPagoPorReserva(long id_reserva);
	
	public PagoDTO crearPago(long id_reserva, long id_consumo, PagoDTO pagoDTO);
	
	public PagoDTO actualizarPago(PagoDTO pagoDTO, long id_pago, long id_reserva, long id_consumo);
	
	public void eliminarPago (long id_pago);
=======
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PagoDto;

public interface PagoService {
	
	public List<PagoDetalleDTO> pagos();
	
	public PagoDto crearPago(PagoDto pagoDto);
	
	public ResponseEntity<Resource> exportPDF(long id_reserva);
	

>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
}
