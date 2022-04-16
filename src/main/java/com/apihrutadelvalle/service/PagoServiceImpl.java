package com.apihrutadelvalle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PagoDto;
import com.apihrutadelvalle.entity.Consumo;
import com.apihrutadelvalle.entity.Pago;
import com.apihrutadelvalle.entity.Reserva;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.ConsumoRepository;
import com.apihrutadelvalle.repository.PagoRepository;
import com.apihrutadelvalle.repository.ReservaRepository;

@Service
public class PagoServiceImpl implements PagoService{
	
	@Autowired
	private PagoRepository pagoRepository;
	
	@Autowired
	private ConsumoRepository consumoRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	
	private PagoDto mapToPagoDTO(Pago pago) {
		
		PagoDto dto = new PagoDto();
		dto.setId_pago(pago.getId_pago());
		dto.setId_reserva(pago.getReserva().getId_reserva());
		dto.setFecha_emision(pago.getFecha_emision());
		dto.setSubtotal(pago.getSubtotal());
		dto.setTotal(pago.getTotal_pago());
		
		return dto;
	}
	
	private PagoDetalleDTO mapToPagoDetalleDTO(Pago pago) {
		
		PagoDetalleDTO detalleDTO = new PagoDetalleDTO();
		
		detalleDTO.setId_pago(pago.getId_pago());
		detalleDTO.setId_reserva(pago.getReserva().getId_reserva());
		detalleDTO.setCliente(pago.getReserva().getUsuario().getNombre());
		detalleDTO.setNum_habitacion(pago.getReserva().getHabitacion().getNum_habitacion());
		detalleDTO.setTipo_habitacion(pago.getReserva().getHabitacion().getTipo_Habitacion().getNombre());
		detalleDTO.setPlanta(pago.getReserva().getHabitacion().getPlanta().getNombre());
		detalleDTO.setFecha_emision(pago.getFecha_emision());

		
		Consumo consumo = consumoRepository.findByReserva(pago.getReserva())
				.orElse(null);
				
		double pagoConsumo;
		if (consumo!=null) {
			pagoConsumo = consumo.getListaDetalle().stream()
					.map(c -> c.getPrecio_total())
					.reduce((t,u) ->{
						return Double.sum(t, u);
					}).orElse(0.0);
		}else {
			pagoConsumo = 0;
		}
		

		
		detalleDTO.setPago_consumo(pagoConsumo);
		detalleDTO.setPago_alojamiento(pago.getReserva().getCosto_alojamiento());
		detalleDTO.setSubtotal(pago.getSubtotal());
		detalleDTO.setTotal(pago.getTotal_pago());
		
		return detalleDTO;
	}
	
	/*private Pago mapToEntity(PagoDto dto, Pago pago) {
		Pago paga = modelMapper.map(dto,pago.getClass());
		return paga;
	
	}*/
	

	@Override
	@Transactional
	public PagoDto crearPago(PagoDto pagoDto) {
		
		
		Reserva reserva = reservaRepository.findById(pagoDto.getId_reserva())
				.orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", pagoDto.getId_reserva()));
		
		
		Consumo consumo = consumoRepository.findByReserva(reserva).orElse(null);
		
		double pagoconsumo;
		if (consumo!=null) {
			pagoconsumo = consumo.getListaDetalle().stream()
					.map(c -> c.getPrecio_total())
					.reduce((t,u) ->{
						return Double.sum(t, u);
					}).orElse(0.0);
		}else {
			pagoconsumo = 0;
		}
		
		
		Pago pago = new Pago();
		
		double pago_alojamiento = reserva.getCosto_alojamiento();
		
		double subtotal = pagoconsumo + pago_alojamiento;
		
		final Double IVA = 0.12;
		
		double total = subtotal + (subtotal * IVA);
		
		double total_redondeado = Math.round(total*100.00)/100.0;
		
		pago.setReserva(reserva);
		pago.setSubtotal(subtotal);
		pago.setTotal_pago(total_redondeado);
		
		
		return mapToPagoDTO(pagoRepository.save(pago));
		
	
	}

	@Override
	@Transactional
	public List<PagoDetalleDTO> pagos() {
		List<PagoDetalleDTO> pagos = pagoRepository.findAll().stream()
				.map(pago-> mapToPagoDetalleDTO(pago)).collect(Collectors.toList());
		return pagos;
	}

}
