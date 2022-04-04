package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.ReservaDTO;

public interface ReservaService {
	
	
	public List<ReservaDTO> mostrarReserva();
	
	public ReservaDTO crearReserva(ReservaDTO resDTO, long id_usuario,long id_habitacion);
	
	public ReservaDTO obtenerReservaID(long id);
	
	public ReservaDTO actualizarReserva(ReservaDTO resDTO,long id_reserva,long id_usuario,long id_habitacion);
	
	public void eliminarReseva(long id);
	
}