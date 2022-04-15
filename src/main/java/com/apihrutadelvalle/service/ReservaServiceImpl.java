package com.apihrutadelvalle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.ReservaDTO;
import com.apihrutadelvalle.dto.ReservaDetalleDTO;
import com.apihrutadelvalle.entity.Habitacion;
import com.apihrutadelvalle.entity.Reserva;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.HabitacionRepository;
import com.apihrutadelvalle.repository.ReservaRepository;
import com.apihrutadelvalle.security.entity.Usuario;
import com.apihrutadelvalle.security.repository.UsuarioRepository;

@Service
public class ReservaServiceImpl implements ReservaService {
	/*cambiar un tipo de objeto a otro*/
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;	
	
	//Convertimos de entidad a DTO
	private ReservaDTO mapToDTO(Reserva reserva){
		
		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setId_reserva(reserva.getId_reserva());
		reservaDTO.setCliente(reserva.getUsuario().getNombre());
		reservaDTO.setId_habitacion(reserva.getHabitacion().getId_habitacion());
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
	
	//Convertimos de entidad a DTO
	private ReservaDetalleDTO mapToDTODetalle(Reserva reserva){
		
		ReservaDetalleDTO detalle = new ReservaDetalleDTO();
		detalle.setId_reserva(reserva.getId_reserva());
		detalle.setDni(reserva.getUsuario().getDni());
		detalle.setCliente(reserva.getUsuario().getNombre());
		detalle.setNum_habitacion(reserva.getHabitacion().getNum_habitacion());
		detalle.setTipo_habitacion(reserva.getHabitacion().getTipo_Habitacion().getNombre());
		detalle.setDescripcion(reserva.getHabitacion().getTipo_Habitacion().getDescripcion());
		detalle.setPlanta(reserva.getHabitacion().getPlanta().getNombre());
		detalle.setEstado(reserva.getEstado());
		detalle.setAdultos(reserva.getAdultos());
		detalle.setNinos(reserva.getNinos());
		detalle.setFecha_reserva(reserva.getFecha_reserva());
		detalle.setFecha_ingreso(reserva.getFecha_ingreso());
		detalle.setFecha_salida(reserva.getFecha_salida());
		detalle.setPrecio_noche(reserva.getHabitacion().getCosto_noche());
		detalle.setCosto_alojamiento(reserva.getCosto_alojamiento());
		detalle.setObservaciones(reserva.getObservaciones());
		detalle.setEstado(reserva.getEstado());

		
		return detalle;
	}
	
	/*private ReservaDTO mapToDTOReserva(Reserva reserva){
		return modelMapper.map(reserva, ReservaDTO.class);
	}*/
	
	
	// Convertimos de DTO a una entidad
	private Reserva mapToEntity(ReservaDTO reservaDTO,Reserva reserva){
		Reserva res = modelMapper.map(reservaDTO, reserva.getClass());
		res.setId_reserva(reserva.getId_reserva());
		return res;
	}
	

	/*-------- METODOS DE CONSULTA -------*/
	
	@Override
	@Transactional(readOnly = true)
	public List<ReservaDetalleDTO> mostrarReserva(){
		List<Reserva> res = reservaRepository.findAll();
		return res.stream().map(reser -> mapToDTODetalle(reser)).collect(Collectors.toList());
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
	public ReservaDTO crearReservabyUsername(ReservaDTO resDTO) {
		
		Habitacion habitacion = habitacionRepository.findById(resDTO.getId_habitacion())
				.orElseThrow(() -> new ResourceNotFoundException("Habitacion", "id", resDTO.getId_habitacion()));
		
		Usuario usuario = usuarioRepository.findByUsername(resDTO.getCliente())
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "username", resDTO.getCliente()));
		
		
		
		//resDTO.setFecha_reserva(new Date());
		//recibe del json y guarda en la bd
		Reserva reservas = mapToEntity(resDTO, new Reserva());
		reservas.setUsuario(usuario);
		reservas.setHabitacion(habitacion);
		
		//guardamos
		Reserva nueva = reservaRepository.save(reservas);
		
		//actualizamos el estado de la habitación de libre a reservada
		habitacion.setEstado("Reservada");
		habitacionRepository.save(habitacion);
		
		//mostramos en  pantalla
		return mapToDTO(nueva);
	}

	
	
	@Override
	@Transactional
	public ReservaDTO actualizarReserva(long id_reserva,ReservaDTO resDTO) {
		
		
		Usuario usuario = usuarioRepository.findByDni(resDTO.getCliente())
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "DNI", resDTO.getCliente()));
		
		// extraemos lo que vamos a editar
		Habitacion habitacion = habitacionRepository.findById(resDTO.getId_habitacion())
				.orElseThrow(() -> new ResourceNotFoundException("Habitacion", "id", resDTO.getId_habitacion()));
		

		
		
		Reserva reservas = reservaRepository.findById(id_reserva)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", id_reserva));
		
		reservas.setUsuario(usuario);
		reservas.setHabitacion(habitacion);
		reservas.setAdultos(resDTO.getAdultos());
		reservas.setNinos(resDTO.getNinos());
		reservas.setFecha_reserva(resDTO.getFecha_reserva());
		reservas.setFecha_salida(resDTO.getFecha_salida());
		reservas.setEstado(resDTO.getEstado());
		

		//actualizamos el reistro
		Reserva reservaAct = reservaRepository.save(reservas);
		
		String estadoHabitacion = "";
		
		if (resDTO.getEstado().equals("Reservada")) {
			estadoHabitacion = "Reservada";
		}else if (resDTO.getEstado().equals("Hospedado")) {
			estadoHabitacion = "Ocupada";
		} else if(resDTO.getEstado().equals("Consumido")){
			/*Si ya termina la instancia
			 * colocamos a la habitaición como
			 * disponible otra vez*/
			estadoHabitacion = "Disponible";
		}
		
		//actualizamos el estado de la habitación de libre a reservada
		habitacion.setEstado(estadoHabitacion);
		habitacionRepository.save(habitacion);
		//vizualisamos
		return mapToDTO(reservaAct);
	}

	@Override
	@Transactional
	public void eliminarReseva(long id) {
		//Obtenemos y verificamos el registro a eliminar
		Reserva reservas = reservaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", id));
		reservaRepository.delete(reservas);
	}

	@Override
	@Transactional
	public ReservaDetalleDTO mostrarDetalleReservaporHabitacion(int num_habitacion) {
		
		Habitacion habitacion = habitacionRepository.findByNumHabitacion(num_habitacion).orElseThrow(() -> new ResourceNotFoundException("Habitación", "número", num_habitacion));
	
		Reserva reserva = reservaRepository.findByHabitacion(habitacion).get();
		
		return mapToDTODetalle(reserva);
	}

	@Override
	@Transactional
	public ReservaDTO crearReservabyDni(ReservaDTO resDTO) {
		
		Habitacion habitacion = habitacionRepository.findById(resDTO.getId_habitacion())
				.orElseThrow(() -> new ResourceNotFoundException("Habitacion", "id", resDTO.getId_habitacion()));
		
		Usuario usuario = usuarioRepository.findByDni(resDTO.getCliente())
				.orElseThrow(() -> new ResourceNotFoundException("Usuario", "DNI", resDTO.getCliente()));
		
		
		
		//resDTO.setFecha_reserva(new Date());
		//recibe del json y guarda en la bd
		Reserva reservas = mapToEntity(resDTO, new Reserva());
		reservas.setUsuario(usuario);
		reservas.setHabitacion(habitacion);
		
		//guardamos
		Reserva nueva = reservaRepository.save(reservas);
		
		String estadoHabitacion = "";
		
		if (resDTO.getEstado().equals("Reservada")) {
			estadoHabitacion = "Reservada";
		}else if (resDTO.getEstado().equals("Hospedado")) {
			estadoHabitacion = "Ocupada";
		} else if(resDTO.getEstado().equals("Consumido")){
			/*Si ya termina la instancia
			 * colocamos a la habitaición como
			 * disponible otra vez*/
			estadoHabitacion = "Disponible";
		}
		
		//actualizamos el estado de la habitación de libre a reservada
		habitacion.setEstado(estadoHabitacion);
		habitacionRepository.save(habitacion);
		
		//mostramos en  pantalla
		return mapToDTO(nueva);
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
