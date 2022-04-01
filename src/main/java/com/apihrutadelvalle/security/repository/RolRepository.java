package com.apihrutadelvalle.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apihrutadelvalle.security.entity.Rol;
import com.apihrutadelvalle.security.enums.RolNombre;

public interface RolRepository extends JpaRepository<Rol, Long>{
	
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
	

}
