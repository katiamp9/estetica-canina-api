package com.ann.estetiCanina.service.interfaces;



import com.ann.estetiCanina.dtos.request.DetalleVentaRequest;
import com.ann.estetiCanina.dtos.response.DetalleVentaResponse;

import java.util.List;

public interface IDetalleVentaService {

    DetalleVentaResponse registrarDetalle(DetalleVentaRequest dto);
    List<DetalleVentaResponse> listarDetalles();
    DetalleVentaResponse obtenerDetallePorId(Long id);
    void eliminarDetalle(Long id);
}
