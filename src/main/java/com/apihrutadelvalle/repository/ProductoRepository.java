package com.apihrutadelvalle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apihrutadelvalle.entity.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
