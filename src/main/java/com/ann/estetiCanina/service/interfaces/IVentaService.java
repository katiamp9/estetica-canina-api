package com.ann.estetiCanina.service.interfaces;



import com.ann.estetiCanina.dtos.request.VentaRequest;
import com.ann.estetiCanina.dtos.response.VentaResponse;

import java.util.List;

public interface IVentaService {

    VentaResponse registrarVenta(VentaRequest dto);
    List<VentaResponse> listarVentas();
    VentaResponse obtenerVentaPorId(Long id);
    void eliminarVenta(Long id);
}
