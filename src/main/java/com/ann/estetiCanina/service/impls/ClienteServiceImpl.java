package com.ann.estetiCanina.service.impls;

import com.ann.estetiCanina.dtos.request.ClienteRequest;
import com.ann.estetiCanina.dtos.response.ClienteResponse;
import com.ann.estetiCanina.models.Cliente;
import com.ann.estetiCanina.repository.ClienteRepository;
import com.ann.estetiCanina.service.interfaces.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponse registrarCliente(ClienteRequest request) {
        Optional<Cliente> existente = clienteRepository.findByCorreo(request.getCorreo());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un cliente con ese correo.");
        }

        Cliente cliente = new Cliente(
                request.getNombre(),
                request.getCorreo(),
                request.getTelefono(),
                request.getDireccion()
        );

        Cliente guardado = clienteRepository.save(cliente);

        return new ClienteResponse(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getCorreo(),
                guardado.getTelefono(),
                guardado.getDireccion()
        );
    }
}

