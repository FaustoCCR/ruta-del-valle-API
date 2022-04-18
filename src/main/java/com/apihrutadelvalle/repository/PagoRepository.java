package com.apihrutadelvalle.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
=======
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1

import com.apihrutadelvalle.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long>{
	
<<<<<<< HEAD
	
=======
	@Query(value = "SELECT p.* from pagos p WHERE p.id_reserva = :id_reserva",nativeQuery = true)
	Optional<Pago> findByIdReserva(long id_reserva);
>>>>>>> e26f1725aad026785e28cf9d07ccbb8d7ab581f1

}
