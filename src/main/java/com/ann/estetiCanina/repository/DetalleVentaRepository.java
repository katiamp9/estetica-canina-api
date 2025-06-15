package com.ann.estetiCanina.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ann.estetiCanina.models.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    
}
