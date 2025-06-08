package com.ann.estetiCanina.controllers;

import com.ann.estetiCanina.dtos.request.ClienteRequest;
import com.ann.estetiCanina.dtos.response.ClienteResponse;
import com.ann.estetiCanina.service.interfaces.IClienteService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final IClienteService clienteService;

    @Autowired
    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/registro")
    public ClienteResponse registrarCliente(@Valid @RequestBody ClienteRequest request) {
        return clienteService.registrarCliente(request);
    }
    @GetMapping
    public List<ClienteResponse> getAllClientes() {
        return clienteService.getAllClientes();
    }

}

