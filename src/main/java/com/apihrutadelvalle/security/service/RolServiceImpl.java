package com.apihrutadelvalle.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apihrutadelvalle.security.entity.Rol;
import com.apihrutadelvalle.security.enums.RolNombre;
import com.apihrutadelvalle.security.repository.RolRepository;

@Service
@Transactional
public class RolServiceImpl implements RolService{
	
	@Autowired
	RolRepository rolRepository;
	
	@Override
	public Optional<Rol> findByRolNombre(RolNombre rolNombre) {
		
		return rolRepository.findByRolNombre(rolNombre);
	}

}
