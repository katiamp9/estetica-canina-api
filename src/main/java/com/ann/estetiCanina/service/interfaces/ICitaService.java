package com.ann.estetiCanina.service.interfaces;

import java.util.List;

import com.ann.estetiCanina.dtos.request.CitaRequest;
import com.ann.estetiCanina.dtos.response.CitaResponse;

public interface ICitaService {

    CitaResponse registrarCita(CitaRequest dto);
    List<CitaResponse> listarCitas();
    CitaResponse findCitaPorId(Long id);
    void eliminarCita(Long id);

}
