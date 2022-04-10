package com.apihrutadelvalle.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.ConsumoDTO;
import com.apihrutadelvalle.dto.DetalleConsumoDTO;
import com.apihrutadelvalle.entity.Consumo;
import com.apihrutadelvalle.entity.DetalleConsumo;
import com.apihrutadelvalle.entity.Reserva;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.ConsumoRepository;
import com.apihrutadelvalle.repository.ReservaRepository;
@Service
public class ConsumoServiceImpl implements ConsumoService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ConsumoRepository consumoRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	private DetalleConsumoDTO mapTODTODetalleConsumo(DetalleConsumo detalleConsumo) {
		
		DetalleConsumoDTO detalle = new DetalleConsumoDTO();
		
		detalle.setId_dtconsumo(detalleConsumo.getId_dtconsumo());
		detalle.setId_consumo(detalleConsumo.getConsumo().getId_consumo());
		detalle.setProducto(detalleConsumo.getProducto().getNombre());
		detalle.setCantidad(detalleConsumo.getCantidad());
		detalle.setPrecio_total(detalleConsumo.getPrecio_total());
		
		return detalle;
	}
	
	//Convertimos de entidad a DTO
	private ConsumoDTO mapToDTOdetalle (Consumo consumo) {
		ConsumoDTO consumoDTO= new ConsumoDTO();
		consumoDTO.setId_consumo(consumo.getId_consumo());
		consumoDTO.setId_reserva(consumo.getReserva().getId_reserva());
		consumoDTO.setFecha(consumo.getFecha());
		consumoDTO.setListaDetalle(consumo.getListaDetalle().stream()
				.map(con -> mapTODTODetalleConsumo(con)).collect(Collectors.toList()));
		
		double total_consumo = consumoDTO.getListaDetalle().stream()
		.map(c->c.getPrecio_total())
		.reduce((t,u) ->{
			return Double.sum(t, u);
		}).orElse(0.0);
		
		consumoDTO.setTotal_consumido(total_consumo);
		
		
		
		return consumoDTO;
	}
	
	private ConsumoDTO mapToDTO(Consumo consumo) {
		return modelMapper.map(consumo, ConsumoDTO.class);
	}
	
	//Convertimos de DTO a entidad
	private Consumo mapToEntity(ConsumoDTO consumoDTO, Consumo consumo) {
		Consumo con = modelMapper.map(consumoDTO, Consumo.class);
		return con;
	}
	
	/*-------- METODOS DE CONSULTA -------*/
	@Override
	@Transactional(readOnly = true)
	public List<ConsumoDTO> mostrarConsumo(){
		List<Consumo> consumo= consumoRepository.findAll();
		return consumo.stream().map(consumos -> mapToDTOdetalle(consumos)).collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true)
	public ConsumoDTO obtenerConsumoID(long id) {
		Consumo consumos= consumoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id));
		return mapToDTOdetalle(consumos);
	}
	
	@Override
	@Transactional
	public ConsumoDTO crearConsumo(ConsumoDTO consumoDTO, long id_reserva) {
		Reserva reserva=reservaRepository.findById(id_reserva).orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", id_reserva));
		
		//recibe lo que ingresamos al json para guardarlo en la BD
		Consumo consumos = new Consumo();
		consumos.setReserva(reserva);
		consumos.setFecha(consumoDTO.getFecha());
		consumos.setListaDetalle(new ArrayList<DetalleConsumo>());

		
		//guardamos
		Consumo consumon= consumoRepository.save(consumos);
		
		//retornamos en pantalla el nuevo registro
		return mapToDTOdetalle(consumon);
	}
	
	@Override
	@Transactional
	public ConsumoDTO actualizarConsumo(ConsumoDTO consumoDTO,long id_consumo, long id_reserva) {
		
		Consumo consumo = consumoRepository.findById(id_consumo).orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id_consumo));
		Reserva reserva=reservaRepository.findById(id_reserva).orElseThrow(() -> new ResourceNotFoundException("Reserva", "id", id_reserva));
		
		//Obtenemos los datos
		consumo.setReserva(reserva);
		consumo.setFecha(consumoDTO.getFecha());
		
		//agregamos los nuevos datos
		//Consumo consumoa = mapToEntity(consumoDTO, consumo);
		
		//actualizamos los datos
		Consumo consumoActualizado = consumoRepository.save(consumo);
		
		//mostramos en pantalla
		return mapToDTOdetalle(consumoActualizado);
	}
	
	@Override
	@Transactional
	public void eliminarConsumo (long id_consumo) {
		//Obtenemos los registros a eliminar
		Consumo consumo = consumoRepository.findById(id_consumo).orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id_consumo));
		consumoRepository.delete(consumo);
	}
}
