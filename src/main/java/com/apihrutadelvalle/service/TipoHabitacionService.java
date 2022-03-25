package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.TipoHabitacionDTO;

public interface TipoHabitacionService {
	
	
	public List<TipoHabitacionDTO> mostrarTipos();
	
	public TipoHabitacionDTO crearTipo(TipoHabitacionDTO tipDto);
	
	public TipoHabitacionDTO obtenerTipoId(long id);
	
	public TipoHabitacionDTO actualizarTipo(TipoHabitacionDTO tDto,long id);
	
	public void eliminarTipo(long id);
	

}
