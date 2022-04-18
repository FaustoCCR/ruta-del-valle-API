package com.apihrutadelvalle.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apihrutadelvalle.dto.ProductoDTO;
import com.apihrutadelvalle.service.ProductoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/productos")
/*Cross Origin --> Angular*/
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<List<ProductoDTO>> productoHb(){
		
		return ResponseEntity.ok(productoService.mostrarProducto());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> obtenerProductoHb(@PathVariable long id){
		
		return ResponseEntity.ok(productoService.obtenerProductoId(id));
	}
	
	/*@Valid --> respeta las validaciones impuestas en la entidad*/
	@PostMapping
	public ResponseEntity<ProductoDTO> guardarProductoHb(@Valid @RequestBody ProductoDTO proDto){
		
		return new ResponseEntity<>(productoService.crearProducto(proDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductoDTO> actualizarProductoHb (@Valid @RequestBody ProductoDTO proDto,@PathVariable long id){
		
		ProductoDTO productoDTO = productoService.actualizarProducto(proDto, id);
		return new ResponseEntity<>(productoDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProductoHb(@PathVariable long id){
		
		productoService.eliminarProducto(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	

}
