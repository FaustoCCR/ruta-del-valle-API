package com.apihrutadelvalle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apihrutadelvalle.entity.Consumo;
import com.apihrutadelvalle.entity.Reserva;

public interface ConsumoRepository extends JpaRepository<Consumo, Long>{
	
	Optional<Consumo> findByReserva(Reserva reserva);
	
	
	@Query(value = "SELECT c.* FROM consumo c WHERE c.id_reserva = :id_reserva",nativeQuery = true)
	Optional<Consumo> findByIdReserva(long id_reserva);

}
