package com.apihrutadelvalle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apihrutadelvalle.entity.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{
	
	@Query(value = "select h from Habitacion h where h.num_habitacion = :num_habitacion")
	Optional<Habitacion> findByNumHabitacion(int num_habitacion);


}
