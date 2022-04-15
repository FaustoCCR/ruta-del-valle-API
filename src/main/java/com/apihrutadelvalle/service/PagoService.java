package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PagoDto;

public interface PagoService {
	
	public List<PagoDetalleDTO> pagos();
	
	public PagoDto crearPago(PagoDto pagoDto);
	

}
