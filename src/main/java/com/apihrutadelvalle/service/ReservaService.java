package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.ReservaDTO;
import com.apihrutadelvalle.dto.ReservaDetalleDTO;

public interface ReservaService {
	
	
	public List<ReservaDetalleDTO> mostrarReserva();
	
	public ReservaDTO crearReservabyUsername(ReservaDTO resDTO);
	
	public ReservaDTO crearReservabyDni(ReservaDTO dto);
	
	public ReservaDTO obtenerReservaID(long id);
	
	public ReservaDTO actualizarReserva(long id_reserva,ReservaDTO resDTO);
	
	public void eliminarReseva(long id);
	
	public ReservaDetalleDTO mostrarDetalleReservaporHabitacion(int num_habitacion);
	
}
