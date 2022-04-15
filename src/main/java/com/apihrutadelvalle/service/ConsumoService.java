package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.ConsumoDTO;

public interface ConsumoService {

	public List<ConsumoDTO> mostrarConsumo();
	
	public ConsumoDTO obtenerConsumoID (long id);
	
	public ConsumoDTO crearConsumo(ConsumoDTO consumoDTO);
	
	public ConsumoDTO actualizarConsumo(ConsumoDTO consumoDTO, long id_consumo, long id_reserva);
	
	public void eliminarConsumo (long id_consumo);
}
