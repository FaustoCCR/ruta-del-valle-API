package com.apihrutadelvalle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apihrutadelvalle.dto.PanelDTO;
import com.apihrutadelvalle.service.PanelService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/panel")
public class PanelController {
	
	@Autowired
	private PanelService panelService;
	
	
	@GetMapping
	public ResponseEntity<PanelDTO> getSummary(){
		
		return ResponseEntity.ok(panelService.getInfoToPanel());
	}

}
