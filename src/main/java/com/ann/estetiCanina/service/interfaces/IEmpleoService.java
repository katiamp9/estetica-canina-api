package com.ann.estetiCanina.service.interfaces;

import com.ann.estetiCanina.dtos.request.EmpleoRequest;
import com.ann.estetiCanina.dtos.response.EmpleoResponse;

import java.util.List;

public interface IEmpleoService {

    EmpleoResponse registrarEmpleo(EmpleoRequest empleoRequest);

    EmpleoResponse getEmpleoById(Long id);

    List<EmpleoResponse> getAllEmpleos();

    EmpleoResponse updateEmpleo(Long id, EmpleoRequest empleoRequest);

    void deleteEmpleo(Long id);
}
