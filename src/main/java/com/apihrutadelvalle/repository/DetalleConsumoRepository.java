package com.apihrutadelvalle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apihrutadelvalle.entity.DetalleConsumo;

public interface DetalleConsumoRepository extends JpaRepository<DetalleConsumo, Long>{
	
	
	@Query(value = "SELECT SUM(dc.precio_total) as \"total\" FROM detalle_consumo dc\r\n"
			+ "JOIN consumo c on (dc.id_consumo = c.id_consumo)\r\n"
			+ "WHERE c.id_reserva = :id_reserva",nativeQuery = true)
	Optional<Double> totalByReserva(long id_reserva);
	
}
