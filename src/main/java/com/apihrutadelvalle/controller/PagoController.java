package com.apihrutadelvalle.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.apihrutadelvalle.dto.PagoDTO;
import com.apihrutadelvalle.dto.PagoDetalleDTO;
=======
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apihrutadelvalle.dto.PagoDetalleDTO;
import com.apihrutadelvalle.dto.PagoDto;
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
import com.apihrutadelvalle.service.PagoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
<<<<<<< HEAD
@RequestMapping("/api/pagos")
=======
@RequestMapping("/api/pago")
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
public class PagoController {
	
	@Autowired
	private PagoService pagoService;
	
<<<<<<< HEAD
	//listar
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<PagoDetalleDTO>> listarPago(){
		
		return ResponseEntity.ok(pagoService.obtenerPago());
	}
	
	//ver por id
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id_pago}")
	public ResponseEntity<PagoDetalleDTO> obtenerPagoId(@PathVariable long id_pago){
		
		return ResponseEntity.ok(pagoService.obtenerPagoId(id_pago));
	}
	
	//crear 
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping()
	public ResponseEntity<PagoDTO> guardarPago(@RequestParam(value = "id_reserva") long id_reserva,
			@RequestParam(value = "id_consumo") long id_consumo,
			@Valid @RequestBody PagoDTO pagoDTO){
		
		PagoDTO pagDTO = pagoService.crearPago(id_reserva, id_consumo, pagoDTO);
		
		return new ResponseEntity<>(pagDTO,HttpStatus.CREATED);
		
	}
	//editar
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id_consumo}")
	public ResponseEntity<PagoDTO> actualizarPago(@PathVariable long id_pago,@RequestParam(value = "id_reserva") long id_reserva,
			@RequestParam(value = "id_consumo") long id_consumo,
			@Valid @RequestBody PagoDTO pagoDTO){
		
		PagoDTO pagDTO = pagoService.actualizarPago(pagoDTO, id_pago, id_reserva,  id_consumo);
		
		return new ResponseEntity<>(pagDTO,HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPago(@PathVariable long id){
		
		pagoService.eliminarPago(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/reserva/{id_reserva}")
	public ResponseEntity<PagoDetalleDTO> obtenerPagoPorReserva(@PathVariable long id_reserva){
		
		PagoDetalleDTO pagoDetalleDTO = pagoService.obtenerPagoPorReserva(id_reserva);
		return new ResponseEntity<>(pagoDetalleDTO,HttpStatus.OK);
=======
	@PostMapping
	public ResponseEntity<PagoDto> realizarPago(@Valid @RequestBody PagoDto pagoDto){
		
		return new ResponseEntity<>(pagoService.crearPago(pagoDto),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PagoDetalleDTO>> listarPagos(){
		
		return ResponseEntity.ok(pagoService.pagos());
	}
	
	//EXPORTAR PDF
	@GetMapping("/reporte/{id_reserva}")
	public ResponseEntity<Resource> exportPDF(@PathVariable long id_reserva){
		
		return pagoService.exportPDF(id_reserva);
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1
	}
	
	

}
