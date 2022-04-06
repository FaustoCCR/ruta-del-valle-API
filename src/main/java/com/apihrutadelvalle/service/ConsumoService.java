package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.ConsumoDTO;

public interface ConsumoService {

	public List<ConsumoDTO> mostrarConsumo();
	
	public ConsumoDTO obtenerConsumoID (Long id);
	
	public ConsumoDTO crearConsumo(ConsumoDTO consumoDTO, Long id_reserva);
	
	public ConsumoDTO actualizarConsumo(ConsumoDTO consumoDTO, long id_reserva);
	
	public void eliminarConsumo (Long id);
}
