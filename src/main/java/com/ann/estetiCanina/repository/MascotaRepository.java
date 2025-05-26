package com.ann.estetiCanina.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ann.estetiCanina.models.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

        List<Mascota> findByClienteId(Long clienteId);

        List<Mascota> findByNombre(String nombre);
}
