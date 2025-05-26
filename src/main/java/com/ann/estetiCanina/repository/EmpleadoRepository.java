package com.ann.estetiCanina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ann.estetiCanina.models.Empleado;
import com.ann.estetiCanina.models.Empleo;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByNombre(String nombre);
    List<Empleado> findByEmpleo(Empleo empleo);
}
