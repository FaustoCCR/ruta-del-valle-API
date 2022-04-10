package com.apihrutadelvalle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apihrutadelvalle.entity.Habitacion;
import com.apihrutadelvalle.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	Optional<Reserva> findByHabitacion(Habitacion habitacion);
}
