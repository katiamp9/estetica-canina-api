package com.ann.estetiCanina.service.interfaces;

import java.util.List;
import com.ann.estetiCanina.dtos.request.MascotaRequest;
import com.ann.estetiCanina.dtos.response.MascotaResponse;

public interface IMascotaService {
    MascotaResponse registrarMascota(MascotaRequest dto);
    List<MascotaResponse> listarMascotas();
    MascotaResponse obtenerMascotaPorId(Long id);
    void eliminarMascota(Long id);
}
