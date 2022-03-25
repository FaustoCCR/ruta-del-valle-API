package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.PlantaDTO;

public interface PlantaService {
	
	public PlantaDTO crearPlanta(PlantaDTO plantaDTO);
	
	public List<PlantaDTO> mostrarPlantas();
	
	public PlantaDTO obtenerPlantaId(long id);
	
	public PlantaDTO actualizarPlanta(PlantaDTO plantaDTO, long id);
	
	public void eliminarPlanta(long id);

}
