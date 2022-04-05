package com.apihrutadelvalle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.ConsumoDTO;
import com.apihrutadelvalle.entity.Consumo;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.ConsumoRepository;
import com.apihrutadelvalle.repository.ReservaRepository;

public class ConsumoServiceImpl implements ConsumoService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ConsumoRepository consumoRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	//Convertimos de entidad a DTO
	private ConsumoDTO maptoDTO (Consumo consumo) {
		ConsumoDTO consumoDTO= new ConsumoDTO();
		consumoDTO.setId_consumo(consumo.getId_consumo());
		consumoDTO.setId_reserva(consumo.getId_reserva());
		consumoDTO.setFecha(consumo.getFecha());
		
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
		return consumo.stream().map(consumos -> mapToDTO(consumos)).collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true)
	public ConsumoDTO obtenerConsumoID(Long id) {
		Consumo consumos= consumoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id));
		return maptoDTO(consumos);
	}
	
	@Override
	@Transactional
	public ConsumoDTO crearConsumo(ConsumoDTO consumoDTO, Long id_reserva) {
		Consumo consumo=consumoRepository.findById(id_reserva).orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id_reserva));
		
		//recibe lo que ingresamos al json para guardarlo en la BD
		Consumo consumos = mapToEntity(consumoDTO, new Consumo());
		
		//guardamos
		Consumo consumon= consumoRepository.save(consumo);
		
		//retornamos en pantalla el nuevo registro
		return mapToDTO(consumon);
	}
	
	@Override
	@Transactional
	public ConsumoDTO actualizarConsumo(ConsumoDTO consumoDTO, long id_reserva) {
		
		//Obtenemos los datos
		Consumo consumo = consumoRepository.findById(id_reserva).orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id_reserva));
		
		//agregamos los nuevos datos
		Consumo consumoa = mapToEntity(consumoDTO, consumo);
		
		//actualizamos los datos
		Consumo consumoActualizado = consumoRepository.save(consumoa);
		
		//mostramos en pantalla
		return mapToDTO(consumoActualizado);
	}
	
	@Override
	public void eliminarConsumo (Long id) {
		//Obtenemos los registros a eliminar
		Consumo consumo = consumoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id));
		consumoRepository.delete(consumo);
	}
}
