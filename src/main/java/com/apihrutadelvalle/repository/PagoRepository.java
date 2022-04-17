package com.apihrutadelvalle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apihrutadelvalle.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long>{
	
	@Query(value = "SELECT p.* from pagos p WHERE p.id_reserva = :id_reserva",nativeQuery = true)
	Optional<Pago> findByIdReserva(long id_reserva);

}
