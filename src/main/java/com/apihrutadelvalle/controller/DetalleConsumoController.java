package com.apihrutadelvalle.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apihrutadelvalle.dto.DetalleConsumoDTO;
import com.apihrutadelvalle.service.DetalleConsumoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/detalleconsumo")
public class DetalleConsumoController {
	
	@Autowired
	private DetalleConsumoService detalleConsumoService;
	
	@GetMapping
	public ResponseEntity<List<DetalleConsumoDTO>> listarDetalleConsumo(){
		
		return ResponseEntity.ok(detalleConsumoService.listaDetallesConsumo());
	}
	
	@PostMapping("/{id_consumo}")
	public ResponseEntity<?> guardarDetalleConsumo(@PathVariable long id_consumo,@Valid @RequestBody DetalleConsumoDTO detalleConsumoDTO){
		
		Object detalle = detalleConsumoService.crearDetalleConsumo(id_consumo,detalleConsumoDTO);
		return new ResponseEntity<>(detalle,HttpStatus.CREATED);
		
	}

}
