package com.apihrutadelvalle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.dto.ProductoDTO;
import com.apihrutadelvalle.entity.Producto;
import com.apihrutadelvalle.exception.ResourceNotFoundException;
import com.apihrutadelvalle.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	//Convertimos de entidad a DTO(Data transfer Object)
	private ProductoDTO mapToDTO(Producto producto) {
		
		ProductoDTO productoDTO = modelMapper.map(producto, ProductoDTO.class);
		
		return productoDTO;
	}
	
	// Convertimos de DTO a una entidad
	private Producto mapToEntity(ProductoDTO productoDTO, Producto producto) {
		
		Producto prodct = modelMapper.map(productoDTO, producto.getClass());
		prodct.setId_producto(producto.getId_producto());
		return prodct;
	}
	
	
	/*-------- METODOS DE CONSULTA -------*/
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductoDTO> mostrarProducto() {
		
		List<Producto> productos = productoRepository.findAll();
		return productos.stream().map(producto -> mapToDTO(producto)).collect(Collectors.toList());
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public ProductoDTO obtenerProductoId(long id) {
		
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));
		
		return mapToDTO(producto);
	}

	@Override
	@Transactional
	public ProductoDTO crearProducto(ProductoDTO productoDto) {
		
		//recibe lo que ingresamos al json para guardarlo en la BD
		Producto producto = mapToEntity(productoDto, new Producto());
		
		//guardamos el registro
		Producto productoNueva = productoRepository.save(producto);
		
		//devolvemos en pantalla el nuevo registro
		return mapToDTO(productoNueva);
	}



	@Override
	@Transactional
	public ProductoDTO actualizarProducto(ProductoDTO proDto, long id) {
		
		//Obtenemos y verificamos el registro a actualizar
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));
		
		//añadimos los nuevos cambios obtenidos del json
		Producto productoDb = mapToEntity(proDto, producto);
		
		//actualizamos el registro
		Producto productoActualizada = productoRepository.save(productoDb);
		
		//Lo presentamos en pantalla
		return mapToDTO(productoActualizada);
		
	}

	@Override
	public void eliminarProducto(long id) {
		
		//Obtenemos y verificamos el registro a eliminar
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto", "id", id));
		
		productoRepository.delete(producto);
		
	}

}
