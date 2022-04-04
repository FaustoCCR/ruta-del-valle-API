package com.apihrutadelvalle.service;

import java.util.List;

import com.apihrutadelvalle.dto.ProductoDTO;

public interface ProductoService {
	
	
	public List<ProductoDTO> mostrarProducto();
	
	public ProductoDTO crearProducto(ProductoDTO productoDto);
	
	public ProductoDTO obtenerProductoId(long id);
	
	public ProductoDTO actualizarProducto(ProductoDTO proDto,long id);
	
	public void eliminarProducto(long id);
	

}
