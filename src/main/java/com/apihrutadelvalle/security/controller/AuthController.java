package com.apihrutadelvalle.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apihrutadelvalle.security.dto.JwtDto;
import com.apihrutadelvalle.security.dto.LoginUsuario;
import com.apihrutadelvalle.security.dto.Mensaje;
import com.apihrutadelvalle.security.dto.NuevoUsuario;
import com.apihrutadelvalle.security.entity.Rol;
import com.apihrutadelvalle.security.entity.Usuario;
import com.apihrutadelvalle.security.enums.RolNombre;
import com.apihrutadelvalle.security.jwt.JwtProvider;
import com.apihrutadelvalle.security.service.RolService;
import com.apihrutadelvalle.security.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = { "http://localhost:4200" })
public class AuthController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	JwtProvider jwtProvider;
	
	//Método para el register
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) 
			
			return new ResponseEntity<>(new Mensaje("Campos inválidos"),HttpStatus.BAD_REQUEST);
		
		if (usuarioService.existsByDni(nuevoUsuario.getDni())) 
			return new ResponseEntity<>(new Mensaje("Cédula ya registrada"),HttpStatus.BAD_REQUEST);
		
		if (usuarioService.existsByUsername(nuevoUsuario.getUsername())) 
			return new ResponseEntity<>(new Mensaje("Username ya existe"),HttpStatus.BAD_REQUEST);
			
		if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) 
			return new ResponseEntity<>(new Mensaje("Email ya existe"),HttpStatus.BAD_REQUEST);
		
		Usuario usuario = new Usuario(
				nuevoUsuario.getDni(),nuevoUsuario.getNombre(),nuevoUsuario.getEmail(),
				nuevoUsuario.getTelefono(),nuevoUsuario.getUsername(),
				passwordEncoder.encode(nuevoUsuario.getPassword()),true);//colocar true al crear
		
		Rol rol = new Rol();
		rol = rolService.findByRolNombre(RolNombre.ROLE_USER).get();
		if (nuevoUsuario.getRol().contains("admin"))
			rol = rolService.findByRolNombre(RolNombre.ROLE_ADMIN).get();
		
		usuario.setRol(rol);
		usuarioService.save(usuario);
		
		return new ResponseEntity<>(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
		
	}
	
	//Método para el login
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario){
		
		
		Authentication authentication = 
				authenticationManager.
				authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(), loginUsuario.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// a partir de la autentificación generamos el token
		String jwt = jwtProvider.generationToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
				
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return new ResponseEntity<JwtDto>(jwtDto,HttpStatus.OK);
		
	}
	
}
