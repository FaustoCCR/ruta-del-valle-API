package com.apihrutadelvalle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.PlantaDTO;
import com.apihrutadelvalle.entity.Planta;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.PlantaRepository;

@Service
public class PlantaServiceImpl implements PlantaService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PlantaRepository plantaRepository;
	
	private PlantaDTO mapToDTO(Planta planta) {
		
		PlantaDTO plantaDTO = modelMapper.map(planta, PlantaDTO.class);
		return plantaDTO;
	}
	
	private Planta mapToEntity(PlantaDTO plantaDTO, Planta plant) {
		
		Planta planta = modelMapper.map(plantaDTO, plant.getClass());
		planta.setId_planta(plant.getId_planta());
		return planta;
	}
	
	/*-------- METODOS DE CONSULTA -------*/
	
	@Override
	@Transactional(readOnly = true)
	public List<PlantaDTO> mostrarPlantas() {
		List<Planta> plantas = plantaRepository.findAll();
		return plantas.stream().map(planta -> mapToDTO(planta)).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public PlantaDTO obtenerPlantaId(long id) {
		
		Planta planta = plantaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Planta", "id", id));
		
		return mapToDTO(planta);
		
	}

	@Override
	@Transactional
	public PlantaDTO crearPlanta(PlantaDTO plantaDTO) {
		
		Planta nuevaPlanta = plantaRepository.save(mapToEntity(plantaDTO, new Planta()));
		
		return mapToDTO(nuevaPlanta);
	}


	@Override
	public PlantaDTO actualizarPlanta(PlantaDTO plantaDTO, long id) {
		Planta planta = plantaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Planta", "id", id));
		
		Planta plantafromDb = mapToEntity(plantaDTO, planta);
		
		return mapToDTO(plantaRepository.save(plantafromDb));
		
	}

	@Override
	public void eliminarPlanta(long id) {
		Planta planta = plantaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Planta", "id", id));
		
		plantaRepository.delete(planta);
		
	}
}
