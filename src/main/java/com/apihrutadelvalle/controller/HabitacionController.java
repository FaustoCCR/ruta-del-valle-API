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
	
	@GetMapping
	public ResponseEntity<List<HabitacionDetalleDTO>> listarHabitaciones(){
		
		return ResponseEntity.ok(habitacionService.obtenerHabitaciones());
	}
	
	@GetMapping("/{id_habitacion}")
	public ResponseEntity<HabitacionDetalleDTO> obtenerHabitacioId(@PathVariable long id_habitacion){
		
		return ResponseEntity.ok(habitacionService.obtenerHabitacionId(id_habitacion));
	}
	
	@PostMapping()
	public ResponseEntity<HabitacionDTO> guardarHabitacion(@RequestParam(value = "id_planta") long id_planta,
			@RequestParam(value = "id_tipo") long id_tipo,
			@Valid @RequestBody HabitacionDTO hDto){
		
		HabitacionDTO habitacionDTO = habitacionService.crearHabitacion(id_planta, id_tipo, hDto);
		
		return new ResponseEntity<>(habitacionDTO,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id_habitacion}")
	public ResponseEntity<HabitacionDTO> actualizarHabitacion(@PathVariable long id_habitacion,@RequestParam(value = "id_planta") long id_planta,
			@RequestParam(value = "id_tipo") long id_tipo,
			@Valid @RequestBody HabitacionDTO hDto){
		
		HabitacionDTO habitacionDTO = habitacionService.actualizarHabitacion(id_planta, id_tipo, id_habitacion, hDto);
		
		return new ResponseEntity<>(habitacionDTO,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarHabitacion(@PathVariable long id){
		
		habitacionService.eliminarHabitacion(id);
		return new ResponseEntity<String>("Habitación eliminada",HttpStatus.OK);
	}
	

}
