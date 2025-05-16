package com.ann.estetiCanina.controllers;

import com.ann.estetiCanina.dtos.request.ServicioRequest;
import com.ann.estetiCanina.dtos.response.ServicioResponse;
import com.ann.estetiCanina.service.interfaces.IServicioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*") 
public class ServicioController {
    
    private final IServicioService servicioService;

    public ServicioController(IServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @PostMapping
    public ResponseEntity<ServicioResponse> registrar(@RequestBody @Valid ServicioRequest dto) {
        return ResponseEntity.ok(servicioService.registrarServicio(dto));
    }

    @GetMapping
    public ResponseEntity<List<ServicioResponse>> listar() {
        return ResponseEntity.ok(servicioService.listarServicios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicioService.obtenerServicioPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }

}
