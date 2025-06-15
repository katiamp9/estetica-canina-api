package com.ann.estetiCanina.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ann.estetiCanina.models.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long>, CitaRepositoryCustom {

    @Query(value = "SELECT obtener_total_cita(:idCita)", nativeQuery = true)
    BigDecimal obtenerTotalCita(@Param("idCita") Integer idCita);

}
