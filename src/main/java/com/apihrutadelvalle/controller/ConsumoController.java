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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apihrutadelvalle.dto.ConsumoDTO;
import com.apihrutadelvalle.service.ConsumoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/consumo")
public class ConsumoController {

	@Autowired
	private ConsumoService consumoService;
	
	//listamos
	@GetMapping
	public ResponseEntity<List<ConsumoDTO>> listarReserva(){
		return ResponseEntity.ok(consumoService.mostrarConsumo());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsumoDTO> obtenerConsumoID(@PathVariable long id){
		return ResponseEntity.ok(consumoService.obtenerConsumoID(id));
	}
	
	//Metodo para crear
	@PostMapping()
	public ResponseEntity<ConsumoDTO> crearConsumo(@Valid @RequestBody ConsumoDTO consumoDTO, @RequestParam(value = "id_reserva") Long id_reserva){
		ConsumoDTO consuDTO = consumoService.crearConsumo(consumoDTO, id_reserva);
		return new ResponseEntity <> (consuDTO, HttpStatus.CREATED);
	}
	
	//Metodo para editar
	@PostMapping("/{id_consumo}")
	public ResponseEntity<ConsumoDTO> actualizarConsumo(@Valid @RequestBody ConsumoDTO consumoDTO, @RequestParam(value = "id_reserva") Long id_reserva){
		ConsumoDTO consumDTO= consumoService.actualizarConsumo(consumoDTO,id_reserva);
		return new ResponseEntity<>(consumDTO, HttpStatus.OK);
	}
	
	//Metodo para eliminar
	@GetMapping("/{id_consumo}")
	public ResponseEntity<String> eliminarConsumo (@PathVariable Long id){
		consumoService.eliminarConsumo(id);
		return new ResponseEntity<String>("Consumo eliminado correctamente",HttpStatus.OK);
	}
}
