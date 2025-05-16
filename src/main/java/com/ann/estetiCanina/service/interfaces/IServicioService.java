package com.ann.estetiCanina.service.interfaces;

import java.util.List;
import com.ann.estetiCanina.dtos.request.ServicioRequest;
import com.ann.estetiCanina.dtos.response.ServicioResponse;

public interface IServicioService {

    ServicioResponse registrarServicio(ServicioRequest dto);
    List<ServicioResponse> listarServicios();
    ServicioResponse obtenerServicioPorId(Long id);
    void eliminarServicio(Long id);

}
