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

import com.apihrutadelvalle.dto.PlantaDTO;
import com.apihrutadelvalle.service.PlantaService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/plantas")
public class PlantaController {
	
	@Autowired
	private PlantaService plantaService;
	
	@GetMapping
	public ResponseEntity<List<PlantaDTO>> listarPlantas(){
		
		return ResponseEntity.ok(plantaService.mostrarPlantas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PlantaDTO> obtenerPlantaId(@PathVariable long id){
		return ResponseEntity.ok(plantaService.obtenerPlantaId(id));
		
	}
	
	@PostMapping
	public ResponseEntity<PlantaDTO> guardarPlanta(@Valid @RequestBody PlantaDTO plantaDTO){
		
		return new ResponseEntity<>(plantaService.crearPlanta(plantaDTO),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PlantaDTO> actualizarPlanta(@Valid @RequestBody PlantaDTO plantaDTO,@PathVariable long id){
		
		return new ResponseEntity<>(plantaService.actualizarPlanta(plantaDTO, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPlanta(@PathVariable long id){
		
		plantaService.eliminarPlanta(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}




}
