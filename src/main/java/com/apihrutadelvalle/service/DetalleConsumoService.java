package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.DetalleConsumoDTO;

public interface DetalleConsumoService {
	
	public DetalleConsumoDTO crearDetalleConsumo(long id_consumo,DetalleConsumoDTO detalleConsumoDTO);
	
	public List<DetalleConsumoDTO> listaDetallesConsumo();
	

}
