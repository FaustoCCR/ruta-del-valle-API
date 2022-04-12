package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.ReservaDTO;
import com.apihrutadelvalle.dto.ReservaDetalleDTO;

public interface ReservaService {
	
	
	public List<ReservaDetalleDTO> mostrarReserva();
	
	public ReservaDTO crearReserva(ReservaDTO resDTO);
	
	public ReservaDTO obtenerReservaID(long id);
	
	public ReservaDTO actualizarReserva(ReservaDTO resDTO,long id_reserva,long id_usuario,long id_habitacion);
	
	public void eliminarReseva(long id);
	
	public ReservaDetalleDTO mostrarDetalleReservaporHabitacion(int num_habitacion);
	
}
