package com.ann.estetiCanina.service.interfaces;


import com.ann.estetiCanina.dtos.request.PagoRequest;
import com.ann.estetiCanina.dtos.response.PagoResponse;

import java.util.List;

public interface IPagoService {

    PagoResponse registrarPago(PagoRequest dto);
    List<PagoResponse> listarPagos();
    PagoResponse obtenerPagoPorId(Long id);
    void eliminarPago(Long id);
}
