package com.apihrutadelvalle.security.service;

import java.util.Optional;

import com.apihrutadelvalle.security.entity.Rol;
import com.apihrutadelvalle.security.enums.RolNombre;


public interface RolService {
	
	public Optional<Rol> findByRolNombre(RolNombre rolNombre);
	
	public void save(Rol rol);

}
