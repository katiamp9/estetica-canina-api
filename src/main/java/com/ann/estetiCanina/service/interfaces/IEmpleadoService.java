package com.ann.estetiCanina.service.interfaces;

import com.ann.estetiCanina.dtos.request.EmpleadoRequest;
import com.ann.estetiCanina.dtos.response.EmpleadoResponse;

import java.util.List;

public interface  IEmpleadoService {

    EmpleadoResponse registrarEmpleado(EmpleadoRequest empleadoRequest);

    EmpleadoResponse getEmpleadoById(Long id);

    List<EmpleadoResponse> getAllEmpleados();

    List<EmpleadoResponse> findEmpleadoByNombre(String nombre);

    EmpleadoResponse updateEmpleado(Long id, EmpleadoRequest empleadoRequest);

    void deleteEmpleado(Long id);
}
