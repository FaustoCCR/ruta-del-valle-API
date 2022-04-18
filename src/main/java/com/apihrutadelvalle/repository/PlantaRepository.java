package com.apihrutadelvalle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apihrutadelvalle.entity.Planta;

public interface PlantaRepository extends JpaRepository<Planta, Long>{
	
	public Optional<Planta> findByNombre(String nombre);
}
