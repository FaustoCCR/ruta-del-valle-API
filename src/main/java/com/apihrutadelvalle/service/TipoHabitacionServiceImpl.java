package com.apihrutadelvalle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.TipoHabitacionDTO;
import com.apihrutadelvalle.entity.Tipo_Habitacion;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.TipoHabitacionRepository;

@Service
public class TipoHabitacionServiceImpl implements TipoHabitacionService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private TipoHabitacionRepository tipoHabitacionRepository;
	
	
	//Convertimos de entidad a DTO(Data transfer Object)
	private TipoHabitacionDTO mapToDTO(Tipo_Habitacion tipo_Habitacion) {
		
		TipoHabitacionDTO tipoHabitacionDTO = modelMapper.map(tipo_Habitacion, TipoHabitacionDTO.class);
		
		return tipoHabitacionDTO;
	}
	
	// Convertimos de DTO a una entidad
	private Tipo_Habitacion mapToEntity(TipoHabitacionDTO tipoHabitacionDTO, Tipo_Habitacion tipo_Habitacion) {
		
		Tipo_Habitacion tipHabitacion = modelMapper.map(tipoHabitacionDTO, tipo_Habitacion.getClass());
		tipHabitacion.setId_tipo(tipo_Habitacion.getId_tipo());
		return tipHabitacion;
	}
	
	
	/*-------- METODOS DE CONSULTA -------*/
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoHabitacionDTO> mostrarTipos() {
		
		List<Tipo_Habitacion> tipos = tipoHabitacionRepository.findAll();
		return tipos.stream().map(tipo -> mapToDTO(tipo)).collect(Collectors.toList());
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public TipoHabitacionDTO obtenerTipoId(long id) {
		
		Tipo_Habitacion tipo_Habitacion = tipoHabitacionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de Habitación", "id", id));
		
		return mapToDTO(tipo_Habitacion);
	}

	@Override
	@Transactional
	public TipoHabitacionDTO crearTipo(TipoHabitacionDTO tipDto) {
		
		//recibe lo que ingresamos al json para guardarlo en la BD
		Tipo_Habitacion tipo_Habitacion = mapToEntity(tipDto, new Tipo_Habitacion());
		
		//guardamos el registro
		Tipo_Habitacion tipo_HabitacionNueva = tipoHabitacionRepository.save(tipo_Habitacion);
		
		//devolvemos en pantalla el nuevo registro
		return mapToDTO(tipo_HabitacionNueva);
	}



	@Override
	@Transactional
	public TipoHabitacionDTO actualizarTipo(TipoHabitacionDTO tDto, long id) {
		
		//Obtenemos y verificamos el registro a actualizar
		Tipo_Habitacion tipo_Habitacion = tipoHabitacionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de Habitación", "id", id));
		
		//añadimos los nuevos cambios obtenidos del json
		Tipo_Habitacion tipoHabitacionDb = mapToEntity(tDto, tipo_Habitacion);
		
		//actualizamos el registro
		Tipo_Habitacion tipoActualizada = tipoHabitacionRepository.save(tipoHabitacionDb);
		
		//Lo presentamos en pantalla
		return mapToDTO(tipoActualizada);
		
	}

	@Override
	public void eliminarTipo(long id) {
		
		//Obtenemos y verificamos el registro a eliminar
		Tipo_Habitacion tipo_Habitacion = tipoHabitacionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo de Habitación", "id", id));
		
		tipoHabitacionRepository.delete(tipo_Habitacion);
		
	}

}
