package com.apihrutadelvalle.security.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PutMapping("/{id_user}")
	public ResponseEntity<UserInformation> acualizarUsuario(@PathVariable long id_user,@Valid @RequestBody UserInformation userInformation){
		
		UserInformation user = userInformationService.actualizarUsuario(id_user, userInformation);
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_user}")
	
	public ResponseEntity<String> eliminarUsuario(@PathVariable long id_user){
		
		userInformationService.eliminarUsuario(id_user);
		return new ResponseEntity<String>("Usuario eliminado",HttpStatus.OK);
	}

}
