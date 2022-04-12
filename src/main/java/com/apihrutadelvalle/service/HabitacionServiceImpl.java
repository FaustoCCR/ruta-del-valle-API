package com.apihrutadelvalle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.HabitacionDTO;
import com.apihrutadelvalle.dto.HabitacionDetalleDTO;
import com.apihrutadelvalle.entity.Habitacion;
import com.apihrutadelvalle.entity.Planta;
import com.apihrutadelvalle.entity.Tipo_Habitacion;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.HabitacionRepository;
import com.apihrutadelvalle.repository.PlantaRepository;
import com.apihrutadelvalle.repository.TipoHabitacionRepository;

@Service
public class HabitacionServiceImpl implements HabitacionService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private PlantaRepository plantaRepository;
	
	@Autowired
	private TipoHabitacionRepository tipoHabitacionRepository;
	
	/*Convertir Entidad a DTO*/
	private HabitacionDetalleDTO mapToDTODetalles(Habitacion habitacion) {
		
		HabitacionDetalleDTO haDto = new HabitacionDetalleDTO();
		haDto.setId_habitacion(habitacion.getId_habitacion());
		haDto.setNum_habitacion(habitacion.getNum_habitacion());
		haDto.setPlanta(habitacion.getPlanta().getNombre());
		haDto.setTipo_habitacion(habitacion.getTipo_Habitacion().getNombre());
		haDto.setDescripcion(habitacion.getTipo_Habitacion().getDescripcion());
		haDto.setMax_adultos(habitacion.getTipo_Habitacion().getMax_adultos());
		haDto.setMax_ninos(habitacion.getTipo_Habitacion().getMax_ninos());
		haDto.setEstado(habitacion.getEstado());
		haDto.setCosto_noche(habitacion.getCosto_noche());
		
		return haDto;
	}
	
	
	
	private HabitacionDTO mapToDTOHabitacion(Habitacion habitacion) {
		
		return modelMapper.map(habitacion, HabitacionDTO.class);
	}
	
	private Habitacion mapToEntity(HabitacionDTO haDto, Habitacion habitacion) {
		
		Habitacion habitacionMap = modelMapper.map(haDto, habitacion.getClass());
		/*habitacionMap.setId_habitacion(habitacion.getId_habitacion());
		habitacionMap.setPlanta(habitacion.getPlanta());
		habitacionMap.setTipo_Habitacion(habitacion.getTipo_Habitacion());*/
		
		return habitacionMap;
	}
	
	/*-------- METODOS DE CONSULTA -------*/

	@Override
	@Transactional(readOnly = true)
	public List<HabitacionDetalleDTO> obtenerHabitaciones() {
		
		List<Habitacion> habitaciones = habitacionRepository.findAll();
		
		return habitaciones.stream()
				.map(habitacion -> mapToDTODetalles(habitacion)).collect(Collectors.toList());
	}



	@Override
	@Transactional(readOnly = true)
	public HabitacionDetalleDTO obtenerHabitacionId(long id_habitacion) {
		
		Habitacion habitacion = habitacionRepository.findById(id_habitacion)
				.orElseThrow(() -> new ResourceNotFoundException("Habitacion", "id", id_habitacion));
		
		return mapToDTODetalles(habitacion);
		
	}


	@Override
	@Transactional
	public HabitacionDTO crearHabitacion(long id_planta, long id_tipo, HabitacionDTO haDto) {
		
		Habitacion habitacion = mapToEntity(haDto, new Habitacion());
		
		Planta planta = plantaRepository.findById(id_planta)
				.orElseThrow(()-> new ResourceNotFoundException("Planta", "id", id_planta));
		
		Tipo_Habitacion tipo_Habitacion = tipoHabitacionRepository.findById(id_tipo)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de habitacion", "id", id_tipo));
		
		habitacion.setPlanta(planta);
		habitacion.setTipo_Habitacion(tipo_Habitacion);
		
		Habitacion habitacionNueva = habitacionRepository.save(habitacion);
		return mapToDTOHabitacion(habitacionNueva);

	}


	@Override
	@Transactional
	public HabitacionDTO actualizarHabitacion(long id_planta, long id_tipo, long id_habitacion, HabitacionDTO haDto) {
		
		/*Extraemos la habitación a modificar*/
		Habitacion habitacion = habitacionRepository.findById(id_habitacion)
				.orElseThrow(() -> new ResourceNotFoundException("Habitacion", "id", id_habitacion));
		
		Planta planta = plantaRepository.findById(id_planta)
				.orElseThrow(()-> new ResourceNotFoundException("Planta", "id", id_planta));
		
		Tipo_Habitacion tipo_Habitacion = tipoHabitacionRepository.findById(id_tipo)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de habitacion", "id", id_tipo));
		
		
		habitacion.setPlanta(planta);
		habitacion.setTipo_Habitacion(tipo_Habitacion);
		habitacion.setNum_habitacion(haDto.getNum_habitacion());
		habitacion.setEstado(haDto.getEstado());
		habitacion.setCosto_noche(haDto.getCosto_noche());
		
		
		Habitacion habitacionActualizada = habitacionRepository.save(habitacion);
		/*mapToEntity(haDto, habitacion);*/
		return mapToDTOHabitacion(habitacionActualizada);
		
	}



	@Override
	@Transactional
	public void eliminarHabitacion(long id_habitacion) {
		
		/*Extraemos la habitación a eliminar*/
		Habitacion habitacion = habitacionRepository.findById(id_habitacion)
				.orElseThrow(() -> new ResourceNotFoundException("Habitacion", "id", id_habitacion));
		
		habitacionRepository.delete(habitacion);
	}



	@Override
	@Transactional
	public HabitacionDetalleDTO obtenerHabitacionPorNumero(int num) {
		
		Habitacion habitacion = habitacionRepository.findByNumHabitacion(num)
				.orElseThrow(() -> new ResourceNotFoundException("Habitacion", "número", num));
		
		return mapToDTODetalles(habitacion);
	}



	@Override
	public List<HabitacionDetalleDTO> obtenerHabitacionesPorEstado(String estado) {
		
		List<Habitacion> habitaciones = habitacionRepository.findByEstado(estado)
				.orElseThrow(() -> new ResourceNotFoundException("Habitaciones", "estado", estado));;
		
		return habitaciones.stream()
				.map(habitacion -> mapToDTODetalles(habitacion)).collect(Collectors.toList());
	}



	

	
	
	

}
