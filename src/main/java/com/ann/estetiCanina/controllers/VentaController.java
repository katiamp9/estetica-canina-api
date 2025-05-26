package com.ann.estetiCanina.controllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ann.estetiCanina.dtos.request.VentaRequest;
import com.ann.estetiCanina.dtos.response.VentaResponse;
import com.ann.estetiCanina.service.interfaces.IVentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {
    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<VentaResponse> registrar(@RequestBody @Valid VentaRequest dto) {
        return ResponseEntity.ok(ventaService.registrarVenta(dto));
    }

    @GetMapping
    public ResponseEntity<List<VentaResponse>> listar() {
        return ResponseEntity.ok(ventaService.listarVentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.obtenerVentaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }
}

