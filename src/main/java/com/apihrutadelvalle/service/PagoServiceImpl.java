package com.apihrutadelvalle.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.HabitacionDTO;
import com.apihrutadelvalle.dto.HabitacionDetalleDTO;
import com.apihrutadelvalle.dto.PagoDTO;

import com.apihrutadelvalle.entity.Habitacion;
import com.apihrutadelvalle.entity.Pago;
import com.apihrutadelvalle.entity.Planta;
import com.apihrutadelvalle.entity.Reserva;
import com.apihrutadelvalle.entity.Tipo_Habitacion;
import com.apihrutadelvalle.entity.Consumo;

import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.PagoRepository;
import com.apihrutadelvalle.repository.ReservaRepository;
import com.apihrutadelvalle.repository.ConsumoRepository;
import com.apihrutadelvalle.repository.HabitacionRepository;
@Service
public class PagoServiceImpl implements PagoService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PagoRepository pagoRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private ConsumoRepository consumoRepository;
	
	@Autowired
	private ConsumoRepository habitacionRepository;
	
	
	
private PagoDetalleDTO mapToDTODetallesPa(Pago pago) {
		
		PagoDetalleDTO paDto = new PagoDetalleDTO();
		paDto.setId_pago(pago.getId_pago());
		paDto.setReserva_pago(pago.getId_reserva().getId_reserva());
		paDto.setConsumo_pago(pago.getId_consumo().getId_consumo());
		paDto.setCliente_pago(pago.getId_reserva().getUsuario().getNombre());
		paDto.setNum_habitacion(pago.getId_reserva().getHabitacion().getNum_habitacion());
		paDto.setCosto_alojamiento(pago.getId_reserva().getCosto_alojamiento());
		paDto.setFecha_emision(pago.getFecha_emision());
		paDto.setSubtotal(pago.getSubtotal());
		paDto.setTotal_pago(pago.getTotal_pago());
		return paDto;
		
}

		
	private PagoDTO mapToDTOPago (Pago pago) {
		return modelMapper.map(pago, PagoDTO.class);
	}
	
	//Convertimos de DTO a entidad
	private Pago mapToEntity(PagoDTO pagoDTO, Pago pago) {
		Pago pag = modelMapper.map(pagoDTO, Pago.class);
		return pag;
	}
	/*-------- METODOS DE CONSULTA -------*/

	@Override
	@Transactional(readOnly = true)
	public List<PagoDetalleDTO> obtenerPago() {
		
		List<Pago> pagos = pagoRepository.findAll();
		
		return pagos.stream()
				.map(pago -> mapToDTODetallesPa(pago)).collect(Collectors.toList());
	}



	@Override
	@Transactional(readOnly = true)
	public PagoDetalleDTO obtenerPagoId(long id_pago) {
		
		Pago pago = pagoRepository.findById(id_pago)
				.orElseThrow(() -> new ResourceNotFoundException("pago", "id", id_pago));
		
		return mapToDTODetallesPa(pago);
		
	}


	@Override
	@Transactional
	public PagoDTO crearPago(long id_reserva, long id_consumo, PagoDTO pagoDTO) {
		
		Pago pago = mapToEntity(pagoDTO, new Pago());
		
		Reserva reserva = reservaRepository.findById(id_reserva)
				.orElseThrow(()-> new ResourceNotFoundException("Reserva", "id", id_reserva));
		
		Consumo consumo = consumoRepository.findById(id_consumo)
				.orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id_consumo));
		
		pago.setId_reserva(reserva);
		pago.setId_consumo(consumo);
		
		Pago pagoNueva = pagoRepository.save(pago);
		return mapToDTOPago(pagoNueva);

	}


	@Override
	@Transactional
	public PagoDTO actualizarPago(PagoDTO pagoDTO, long id_pago, long id_reserva, long id_consumo) {
		
		/*Extraemos el pago a modificar*/
		Pago pago = pagoRepository.findById(id_pago)
				.orElseThrow(() -> new ResourceNotFoundException("id_pago", "id", id_pago));
		
		Reserva reserva = reservaRepository.findById(id_reserva)
				.orElseThrow(()-> new ResourceNotFoundException("Reserva", "id", id_reserva));
		
		Consumo consumo = consumoRepository.findById(id_consumo)
				.orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id_consumo));
		
		pago.setId_reserva(reserva);
		pago.setId_consumo(consumo);
		pago.setFecha_emision(pagoDTO.getFecha_emision());
		pago.setSubtotal(pagoDTO.getSubtotal());
		pago.setTotal_pago(pagoDTO.getPago_total());
		
		
		Pago pagoActualizada = pagoRepository.save(pago);
		/*mapToEntity(pagoDto, pago);*/
		return mapToDTOPago(pagoActualizada);
		
	}



	@Override
	@Transactional
	public void eliminarPago (long id_pago) {
		
		/*Extraemos el pago a eliminar*/
		Pago pago = pagoRepository.findById(id_pago)
				.orElseThrow(() -> new ResourceNotFoundException("Pago", "id", id_pago));
		
		pagoRepository.delete(pago);
	}



	@Override
	@Transactional
	public PagoDetalleDTO obtenerPagoPorReserva(long id_reserva) {
		
		Pago pago = pagoRepository.findById(id_reserva)
				.orElseThrow(() -> new ResourceNotFoundException("Pago", "id", id_reserva));
		
		return mapToDTODetallesPa(pago);
	}



}
