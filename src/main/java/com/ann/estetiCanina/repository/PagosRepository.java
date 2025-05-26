package com.ann.estetiCanina.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.ann.estetiCanina.models.Pago;

public interface PagosRepository extends JpaRepository<Pago, Long> {
    
}

