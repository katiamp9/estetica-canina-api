package com.ann.estetiCanina.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.ann.estetiCanina.dtos.request.CitaRequest;
import com.ann.estetiCanina.dtos.response.CitaDetalladaResponse;
import com.ann.estetiCanina.dtos.response.CitaResponse;

public interface ICitaService {

    CitaResponse registrarCita(CitaRequest dto);

    List<CitaResponse> listarCitas();

    CitaResponse findCitaPorId(Long id);

    void eliminarCita(Long id);

    BigDecimal obtenerTotalCita(Integer idCita);

    List<CitaDetalladaResponse> obtenerDatosCitaDetallada(Integer idCita);
}
