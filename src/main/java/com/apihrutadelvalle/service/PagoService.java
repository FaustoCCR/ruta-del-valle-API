package com.apihrutadelvalle.service;

import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PagoDTO;

public interface PagoService {
	
	/*
	 * Métodos provisionales
	 * */
	
	public List<PagoDetalleDTO> pagos();
	
	public PagoDTO crearPago(PagoDTO pagoDto);
	
	public ResponseEntity<Resource> exportPDF(long id_reserva);
	
}
