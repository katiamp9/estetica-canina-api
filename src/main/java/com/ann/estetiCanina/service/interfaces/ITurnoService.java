package com.ann.estetiCanina.service.interfaces;

import com.ann.estetiCanina.dtos.request.TurnoRequest;
import com.ann.estetiCanina.dtos.response.TurnoResponse;
import java.util.List;
public interface ITurnoService {

    TurnoResponse registrarTurno(TurnoRequest dto);
    List<TurnoResponse> listarTurnos();
    TurnoResponse obtenerTurnoPorId(Long id);
    void eliminarTurno(Long id);

} 
