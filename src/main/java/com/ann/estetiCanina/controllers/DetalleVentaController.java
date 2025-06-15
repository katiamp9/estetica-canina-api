package com.ann.estetiCanina.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ann.estetiCanina.dtos.request.DetalleVentaRequest;
import com.ann.estetiCanina.dtos.response.DetalleVentaResponse;
import com.ann.estetiCanina.service.interfaces.IDetalleVentaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalles-venta")
@CrossOrigin(origins = "*")
public class DetalleVentaController {

    private final IDetalleVentaService detalleVentaService;

    public DetalleVentaController(IDetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @PostMapping
    public ResponseEntity<DetalleVentaResponse> registrar(@RequestBody @Valid DetalleVentaRequest dto) {
        return ResponseEntity.ok(detalleVentaService.registrarDetalle(dto));
    }

    @GetMapping
    public ResponseEntity<List<DetalleVentaResponse>> listar() {
        return ResponseEntity.ok(detalleVentaService.listarDetalles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentaResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(detalleVentaService.obtenerDetallePorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleVentaService.eliminarDetalle(id);
        return ResponseEntity.noContent().build();
    }
}
