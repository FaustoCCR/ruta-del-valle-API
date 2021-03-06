package com.apihrutadelvalle.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import com.apihrutadelvalle.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long>{
	

	@Query(value = "SELECT p.* from pagos p WHERE p.id_reserva = :id_reserva",nativeQuery = true)
	Optional<Pago> findByIdReserva(long id_reserva);

	
	@Query(value = "SELECT * from pagos ORDER BY id_pago desc LIMIT 5",nativeQuery = true)
	List<Pago> currentPayments();


}
