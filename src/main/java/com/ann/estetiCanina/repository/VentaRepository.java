package com.ann.estetiCanina.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.ann.estetiCanina.models.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    
}
