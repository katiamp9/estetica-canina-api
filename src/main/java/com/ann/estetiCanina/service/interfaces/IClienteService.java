package com.ann.estetiCanina.service.interfaces;

import com.ann.estetiCanina.dtos.response.ClienteResponse;
import com.ann.estetiCanina.dtos.request.ClienteRequest;


public interface IClienteService {
    ClienteResponse registrarCliente(ClienteRequest request);
}
