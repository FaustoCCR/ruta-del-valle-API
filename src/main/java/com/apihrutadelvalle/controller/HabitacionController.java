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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apihrutadelvalle.dto.HabitacionDTO;
import com.apihrutadelvalle.dto.HabitacionDetalleDTO;
import com.apihrutadelvalle.service.HabitacionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {
	
	@Autowired
	private HabitacionService habitacionService;
	
	//listar
	@GetMapping
	public ResponseEntity<List<HabitacionDetalleDTO>> listarHabitaciones(){
		
		return ResponseEntity.ok(habitacionService.obtenerHabitaciones());
	}
	
	//ver por id
	@GetMapping("/{id_habitacion}")
	public ResponseEntity<HabitacionDetalleDTO> obtenerHabitacioId(@PathVariable long id_habitacion){
		
		return ResponseEntity.ok(habitacionService.obtenerHabitacionId(id_habitacion));
	}
	
	//crear 
	@PostMapping()
	public ResponseEntity<HabitacionDTO> guardarHabitacion(
			@Valid @RequestBody HabitacionDTO hDto){
		
		HabitacionDTO habitacionDTO = habitacionService.crearHabitacion(hDto);
		
		return new ResponseEntity<>(habitacionDTO,HttpStatus.CREATED);
		
	}
	//editar
	@PutMapping("/{id_habitacion}")
	public ResponseEntity<HabitacionDTO> actualizarHabitacion(@PathVariable long id_habitacion,
			@Valid @RequestBody HabitacionDTO hDto){
		
		HabitacionDTO habitacionDTO = habitacionService.actualizarHabitacion(id_habitacion, hDto);
		
		return new ResponseEntity<>(habitacionDTO,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarHabitacion(@PathVariable long id){
		
		habitacionService.eliminarHabitacion(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/num_habitacion/{num}")
	public ResponseEntity<HabitacionDetalleDTO> obtenerHabitacionPorNumero(@PathVariable int num){
		
		HabitacionDetalleDTO habitacionDetalleDTO = habitacionService.obtenerHabitacionPorNumero(num);
		return new ResponseEntity<>(habitacionDetalleDTO,HttpStatus.OK);
	}
	
	@GetMapping("/seleccion")
	public ResponseEntity<List<HabitacionDetalleDTO>> obtenerHabitacionesPorEstado(@RequestParam(value = "estado") String estado){
		
		List<HabitacionDetalleDTO> habitaciones = habitacionService.obtenerHabitacionesPorEstado(estado);
		
		return ResponseEntity.ok(habitaciones);
	}
	

}
