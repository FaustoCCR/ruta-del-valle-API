package com.apihrutadelvalle.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PagoDto;

public interface PagoService {
	
	public List<PagoDetalleDTO> pagos();
	
	public PagoDto crearPago(PagoDto pagoDto);
	
	public ResponseEntity<Resource> exportPDF(long id_reserva);
	

}
