package com.apihrutadelvalle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.DetalleConsumoDTO;
import com.apihrutadelvalle.entity.Consumo;
import com.apihrutadelvalle.entity.DetalleConsumo;
import com.apihrutadelvalle.entity.Producto;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.ConsumoRepository;
import com.apihrutadelvalle.repository.DetalleConsumoRepository;
import com.apihrutadelvalle.repository.ProductoRepository;
import com.apihrutadelvalle.security.dto.Mensaje;

@Service
public class DetalleConsumoServiceImpl implements DetalleConsumoService{
	
	@Autowired
	private DetalleConsumoRepository detalleConsumoRepository;
	
	/*@Autowired
	private ModelMapper modelMapper;*/
	
	@Autowired
	private ConsumoRepository consumoRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	private DetalleConsumoDTO mapTODTO(DetalleConsumo detalleConsumo) {
		
		DetalleConsumoDTO detalle = new DetalleConsumoDTO();
		
		detalle.setId_dtconsumo(detalleConsumo.getId_dtconsumo());
		detalle.setId_consumo(detalleConsumo.getConsumo().getId_consumo());
		detalle.setProducto(detalleConsumo.getProducto().getNombre());
		detalle.setCantidad(detalleConsumo.getCantidad());
		detalle.setPrecio_total(detalleConsumo.getPrecio_total());
		
		return detalle;
	}
	
	/*private DetalleConsumo mapToEntity(DetalleConsumoDTO detalleConsumoDTO, DetalleConsumo detalle) {
		DetalleConsumo detalleConsumo = modelMapper.map(detalleConsumoDTO, detalle.getClass());
		
		return detalleConsumo;
	}*/

	@Override
	@Transactional
	public Object crearDetalleConsumo(long id_consumo,DetalleConsumoDTO detalleConsumoDTO) {
		
		DetalleConsumo detalleConsumo = new DetalleConsumo();
		
		Consumo consumo = consumoRepository.findById(id_consumo)
				.orElseThrow(() -> new ResourceNotFoundException("Consumo", "id", id_consumo));
		Producto producto = productoRepository.findByNombre(detalleConsumoDTO.getProducto()).orElseThrow(() -> new ResourceNotFoundException("Producto", "nombre", detalleConsumoDTO.getProducto()));
		
		int stock = producto.getStock();
		if (stock>0) {
			
			detalleConsumo.setConsumo(consumo);
			detalleConsumo.setProducto(producto);
			detalleConsumo.setCantidad(detalleConsumoDTO.getCantidad());
			detalleConsumo.setPrecio_total(detalleConsumoDTO.getCantidad() * producto.getPrecio_venta());
			
			DetalleConsumo nuevo = detalleConsumoRepository.save(detalleConsumo);
			
			/*
			 * */
			
			int stockFinal = stock-detalleConsumo.getCantidad();
			
			producto.setStock(stockFinal);
			productoRepository.save(producto);
				
			return mapTODTO(nuevo);
			
		}else {
			return new Mensaje("Stock acabado del producto");
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleConsumoDTO> listaDetallesConsumo() {
		
		List<DetalleConsumo> detalles = detalleConsumoRepository.findAll();
		
		return detalles.stream().map(detalle -> mapTODTO(detalle)).collect(Collectors.toList());
	}

}
