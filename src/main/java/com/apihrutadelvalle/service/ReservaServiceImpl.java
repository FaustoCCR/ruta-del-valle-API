package com.apihrutadelvalle.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.ReservaDTO;
import com.apihrutadelvalle.entity.Habitacion;
import com.apihrutadelvalle.entity.Reserva;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.HabitacionRepository;
import com.apihrutadelvalle.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {
	/*cambiar un tipo de objeto a otro*/
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	/*falta usuario*/
	
	
	//Convertimos de entidad a DTO
	private ReservaDTO mapToDTO(Reserva reserva){
		
		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setId_reserva(reserva.getId_reserva());
		reservaDTO.setId_usuario(reserva.getId_usuario());
		reservaDTO.setId_habitacion(reserva.getId_habitacion());
		reservaDTO.setFecha_reserva(reserva.getFecha_reserva());
		reservaDTO.setFecha_ingreso(reserva.getFecha_ingreso());
		reservaDTO.setFecha_salida(reserva.getFecha_salida());;
		reservaDTO.setAdultos(reserva.getAdultos());
		reservaDTO.setNinos(reserva.getNinos());
		reservaDTO.setObservaciones(reserva.getObservaciones());
		reservaDTO.setCosto_alojamiento(reserva.getCosto_alojamiento());
		reservaDTO.setEstado(reserva.getEstado());
		
		return reservaDTO;
	}
	
	private ReservaDTO mapToDTOReserva(Reserva reserva){
		return modelMapper.map(reserva, ReservaDTO.class);
	}
	
	
	// Convertimos de DTO a una entidad
	private Reserva mapToEntity(ReservaDTO reservaDTO,Reserva reserva){
		Reserva res = modelMapper.map(reservaDTO, reserva.getClass());
		res.setId_reserva(reserva.getId_reserva());
		return res;
	}
	

	/*-------- METODOS DE CONSULTA -------*/
	
	@Override
	@Transactional(readOnly = true)
	public List<ReservaDTO> mostrarReserva(){
		
		List<Reserva> res = reservaRepository.findAll();
		return res.stream().map(reser -> mapToDTO(reser)).collect(Collectors.toList());
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public ReservaDTO obtenerReservaID(long id) {
		
		Reserva reservas = reservaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", id));
		return mapToDTO(reservas);
		
	}

	
	@Override
	@Transactional
	public ReservaDTO crearReserva(ReservaDTO resDTO, long id_usu, long id_hab) {
		
		Habitacion habitacion = habitacionRepository.findById(id_hab)
				.orElseThrow(() -> new ResourceNotFoundException("Habitacion", "id", id_hab));
		/*
		Usuario usuario = usuarioRepository.findById(id_usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id_usuario));
		*/
		//recibe del json y guarda en l abd
		Reserva reservas = mapToEntity(resDTO, new Reserva());
		reservas.setId_habitacion(habitacion.getId_habitacion());
		
		//guardamos
		Reserva nueva = reservaRepository.save(reservas);
		
		//mostramos en  pantalla
		return mapToDTOReserva(nueva);
	}

	
	
	@Override
	@Transactional
	public ReservaDTO actualizarReserva(ReservaDTO resDTO, long id_reserva,long id_usuario,long id_habitacion) {
		// extraemos lo que vamos a editar
		Habitacion habitacion = habitacionRepository.findById(id_habitacion)
				.orElseThrow(() -> new ResourceNotFoundException("Habitacion", "id", id_habitacion));
		/*
		Usuario ususario = UsuarioRepository.findById(id_usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id_usuario));
		*/
		Reserva reservas = reservaRepository.findById(id_reserva)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", id_reserva));
		
		reservas.setId_habitacion(habitacion.getId_habitacion());
		reservas.setAdultos(resDTO.getAdultos());
		reservas.setNinos(resDTO.getNinos());
		reservas.setFecha_reserva(resDTO.getFecha_reserva());
		reservas.setFecha_salida(resDTO.getFecha_salida());
		reservas.setCosto_alojamiento(resDTO.getCosto_alojamiento());
		reservas.setEstado(resDTO.getEstado());
		
		//añadimos los cambios
		Reserva reservasguar = mapToEntity(resDTO, reservas);
		//actualizamos el reistro
		Reserva reservaAct = reservaRepository.save(reservasguar);
		//vizualisamos
		return mapToDTOReserva(reservaAct);
	}

	@Override
	@Transactional
	public void eliminarReseva(long id) {
		//Obtenemos y verificamos el registro a eliminar
		Reserva reservas = reservaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", id));
		reservaRepository.delete(reservas);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
