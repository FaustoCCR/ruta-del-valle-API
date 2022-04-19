package com.apihrutadelvalle.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PanelDTO;
import com.apihrutadelvalle.entity.Consumo;
import com.apihrutadelvalle.entity.Pago;
import com.apihrutadelvalle.repository.ConsumoRepository;
import com.apihrutadelvalle.repository.HabitacionRepository;
import com.apihrutadelvalle.repository.PagoRepository;

@Service
public class PanelServiceImpl implements PanelService{
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private PagoRepository pagoRepository;
	
	
	@Autowired
	private ConsumoRepository consumoRepository;
	
	
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
	

	@Override
	@Transactional
	public PanelDTO getInfoToPanel() {
		
		Optional<Integer[]> list = habitacionRepository.getCountofRoomState();
		if (list.isPresent()) {
			
			Integer[] counts = list.get();
			
			int hb_disponibles = counts[0];
			int hb_ocupadas = counts[1];
			int hb_reservadas = counts[2];
			
			PanelDTO panelDTO = new PanelDTO();
			panelDTO.setHb_disponibles(hb_disponibles);
			panelDTO.setHb_ocupadas(hb_ocupadas);
			panelDTO.setHb_reservadas(hb_reservadas);
			
			List<PagoDetalleDTO> pagos = pagoRepository.currentPayments().stream()
					.map(pago-> mapToPagoDetalleDTO(pago)).collect(Collectors.toList());
			
			panelDTO.setPagos(pagos);
			
			return panelDTO;
			
		}else {
			return null;
		}
	}
	
}
