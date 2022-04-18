package com.apihrutadelvalle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apihrutadelvalle.entity.Habitacion;
import com.apihrutadelvalle.entity.Reserva;
import com.apihrutadelvalle.security.entity.Usuario;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	Optional<Reserva> findByHabitacion(Habitacion habitacion);
	
	Optional<List<Reserva>> findByUsuario(Usuario usuario);
}
