package com.ann.estetiCanina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ann.estetiCanina.models.Empleo;

public interface EmpleoRepository extends JpaRepository<Empleo, Long> {
}
