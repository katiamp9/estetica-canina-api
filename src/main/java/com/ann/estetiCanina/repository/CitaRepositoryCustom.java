package com.ann.estetiCanina.repository;

import java.util.List;

import com.ann.estetiCanina.dtos.response.CitaDetalladaResponse;

public interface CitaRepositoryCustom {
    List<CitaDetalladaResponse> obtenerDatosCitaDetallada(Integer idCita);
}
