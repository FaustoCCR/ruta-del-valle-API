package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.HabitacionDTO;
import com.apihrutadelvalle.dto.HabitacionDetalleDTO;

public interface HabitacionService {
	
	public HabitacionDTO crearHabitacion(long id_planta, long id_tipo, HabitacionDTO haDto);
	
	public List<HabitacionDetalleDTO> obtenerHabitaciones();
	
	public HabitacionDetalleDTO obtenerHabitacionId(long id_habitacion);
	
	public HabitacionDTO actualizarHabitacion(long id_planta, long id_tipo, long id_habitacion, HabitacionDTO haDto);
	
	public void eliminarHabitacion(long id_habitacion);
}
