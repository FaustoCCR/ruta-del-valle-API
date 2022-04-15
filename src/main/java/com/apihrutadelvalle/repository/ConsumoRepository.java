package com.apihrutadelvalle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apihrutadelvalle.entity.Consumo;
import com.apihrutadelvalle.entity.Reserva;

public interface ConsumoRepository extends JpaRepository<Consumo, Long>{
	
	Optional<Consumo> findByReserva(Reserva reserva);

}
