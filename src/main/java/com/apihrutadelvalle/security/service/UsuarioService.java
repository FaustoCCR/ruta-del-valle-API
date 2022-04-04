package com.apihrutadelvalle.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.security.entity.Usuario;
import com.apihrutadelvalle.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> getByUsername(String username) {
		
		return usuarioRepository.findByUsername(username);
		
	}
	
	public boolean existsByUsername(String username) {
		
		return usuarioRepository.existsByUsername(username);
	}
	
	public boolean existsByEmail(String email) {
		
		return usuarioRepository.existsByEmail(email);
	}
	
	public void save(Usuario usuario) {
		
		usuarioRepository.save(usuario);
	}

}
