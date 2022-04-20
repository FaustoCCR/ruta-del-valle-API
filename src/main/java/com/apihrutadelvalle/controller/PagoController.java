package com.apihrutadelvalle.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.apihrutadelvalle.dto.PagoDTO;
import com.apihrutadelvalle.service.PagoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/pago")
public class PagoController {
	
	@Autowired
	private PagoService pagoService;
	
	@PostMapping
	public ResponseEntity<PagoDTO> realizarPago(@Valid @RequestBody PagoDTO pagoDto){
		
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
	}
	
	

}
