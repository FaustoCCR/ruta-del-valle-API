 package com.apihrutadelvalle.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apihrutadelvalle.security.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	boolean existsByEmail(String email);
	
	boolean existsByDni(String dni);
	
	
	
	

}
