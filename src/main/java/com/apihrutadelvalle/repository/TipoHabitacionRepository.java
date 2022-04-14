package com.apihrutadelvalle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apihrutadelvalle.entity.Tipo_Habitacion;


public interface TipoHabitacionRepository extends JpaRepository<Tipo_Habitacion, Long>{
	
	public Optional<Tipo_Habitacion> findByNombre(String nombreTipo);
}
