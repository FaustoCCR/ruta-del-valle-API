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

import com.apihrutadelvalle.dto.ReservaDTO;
import com.apihrutadelvalle.service.ReservaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/reserva")

public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	
	//listar
	@GetMapping
	public ResponseEntity<List<ReservaDTO> > listarReserva(){
		return ResponseEntity.ok(reservaService.mostrarReserva());
	}
	/*
	//por ID
	@GetMapping("/{id_reserva}")
	public ResponseEntity<ReservaDTO> obtenerReservaID(@PathVariable long id_reserva){
		return ResponseEntity.ok(reservaService.obtenerReservaID(id_reserva));
	}
	*/
	
	//crear
	@PostMapping()
	public ResponseEntity<ReservaDTO> crearReserva(@Valid @RequestBody ReservaDTO resDTO,
			@RequestParam(value = "id_habitacion") long id_habitacion, @RequestParam(value = "id_usuario") long id_usuario){
		ReservaDTO reservaDTO = reservaService.crearReserva(resDTO, id_usuario, id_habitacion);
		return new ResponseEntity <> (reservaDTO, HttpStatus.CREATED);
	}
	//editar
	@PostMapping("/{id_reserva}")
	public ResponseEntity<ReservaDTO> actualizarReserva(@Valid @RequestBody ReservaDTO resDTO,@PathVariable long id_reserva,
			@RequestParam(value = "id_habitacion") long id_habitacion, @RequestParam(value = "id_usuario") long id_usuario){
		ReservaDTO reservaDTO = reservaService.actualizarReserva(resDTO, id_usuario, id_reserva, id_habitacion);
		return new ResponseEntity <> (reservaDTO, HttpStatus.OK);
	}

	//eliminar
	@GetMapping("/{id_reserva}")
	public ResponseEntity<String> elikminarReserva(@PathVariable long id){
		reservaService.eliminarReseva(id);
		return new ResponseEntity<String>("Reserva eliminada",HttpStatus.OK);
	}
	
	
}
