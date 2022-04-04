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

import com.apihrutadelvalle.dto.TipoHabitacionDTO;
import com.apihrutadelvalle.service.TipoHabitacionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/tiposhb")
/*Cross Origin --> Angular*/
public class TipoHabitacionController {
	
	@Autowired
	private TipoHabitacionService tipoHabitacionService;
	
	@GetMapping
	public ResponseEntity<List<TipoHabitacionDTO>> tiposHb(){
		
		return ResponseEntity.ok(tipoHabitacionService.mostrarTipos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoHabitacionDTO> obtenerTipoHb(@PathVariable long id){
		
		return ResponseEntity.ok(tipoHabitacionService.obtenerTipoId(id));
	}
	
	/*@Valid --> respeta las validaciones impuestas en la entidad*/
	@PostMapping
	public ResponseEntity<TipoHabitacionDTO> guardarTipoHb(@Valid @RequestBody TipoHabitacionDTO tiDto){
		
		return new ResponseEntity<>(tipoHabitacionService.crearTipo(tiDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoHabitacionDTO> actualizarTipoHb (@Valid @RequestBody TipoHabitacionDTO tiDto,@PathVariable long id){
		
		TipoHabitacionDTO tipoHabitacionDTO = tipoHabitacionService.actualizarTipo(tiDto, id);
		return new ResponseEntity<>(tipoHabitacionDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarTipoHb(@PathVariable long id){
		
		tipoHabitacionService.eliminarTipo(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	

}
