package com.apihrutadelvalle.security.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apihrutadelvalle.security.dto.Mensaje;
import com.apihrutadelvalle.security.dto.UserInformation;
import com.apihrutadelvalle.security.service.UserInformationService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserInformationService userInformationService;
	
	@GetMapping
	public ResponseEntity<List<UserInformation>> listarUsuarios(){
		
		return ResponseEntity.ok(userInformationService.listarUsuarios());
	}
	
	@GetMapping("/{id_user}")
	public ResponseEntity<UserInformation> obtenerUsuarioId(@PathVariable long id_user){
		
		return ResponseEntity.ok(userInformationService.obtenerUsuarioId(id_user));
	}
	
	@GetMapping("/usuario/{username}")
	public ResponseEntity<UserInformation> obtenerUsuarioByUsername(@PathVariable String username){
		
		UserInformation userInformation = userInformationService.findByUsername(username);
		
		return ResponseEntity.ok(userInformation);
	}
	
	@PutMapping("/{id_user}")
	public ResponseEntity<?> acualizarUsuario(@PathVariable long id_user,@Valid @RequestBody UserInformation userInformation,BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) 
			
			return new ResponseEntity<>(new Mensaje("Campos inválidos"),HttpStatus.BAD_REQUEST);
		
		if (userInformationService.existsByDni(userInformation.getDni())&& !userInformation.getDni().equals(userInformationService.obtenerUsuarioId(id_user).getDni())) 
			return new ResponseEntity<>(new Mensaje("Cédula ya registrada"),HttpStatus.BAD_REQUEST);
		
		if (userInformationService.existsByUsername(userInformation.getUsername())&&!userInformation.getUsername().equals(userInformationService.obtenerUsuarioId(id_user).getUsername()))
			return new ResponseEntity<>(new Mensaje("Username ya existe"),HttpStatus.BAD_REQUEST);
			
		if (userInformationService.existsByEmail(userInformation.getEmail())&&!userInformation.getEmail().equals(userInformationService.obtenerUsuarioId(id_user).getEmail())) 
			return new ResponseEntity<>(new Mensaje("Email ya existe"),HttpStatus.BAD_REQUEST);
		UserInformation user = userInformationService.actualizarUsuario(id_user, userInformation);
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_user}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable long id_user){
		
		userInformationService.eliminarUsuario(id_user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
