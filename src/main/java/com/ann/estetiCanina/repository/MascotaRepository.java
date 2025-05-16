package com.ann.estetiCanina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ann.estetiCanina.models.Mascota;

public interface MascotaRepository extends JpaRepository <Mascota, Long>{
    
}
