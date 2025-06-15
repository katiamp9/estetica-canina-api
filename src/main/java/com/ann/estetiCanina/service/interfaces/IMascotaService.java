package com.ann.estetiCanina.service.interfaces;

import com.ann.estetiCanina.dtos.request.MascotaRequest;
import com.ann.estetiCanina.dtos.response.MascotaResponse;

import java.util.List;

public interface IMascotaService {

    MascotaResponse registrarMascota(MascotaRequest mascotaRequest);

    MascotaResponse obtenerMascotaPorId(Long id);

    List<MascotaResponse> obtenerTodasLasMascotas();

    List<MascotaResponse> obtenerMascotasPorCliente(Long clienteId);

    List<MascotaResponse> buscarMascotasPorNombre(String nombre);

    MascotaResponse actualizarMascota(Long id, MascotaRequest mascotaRequest);

    void eliminarMascota(Long id);
}
