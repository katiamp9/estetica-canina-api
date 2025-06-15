package com.ann.estetiCanina.controllers;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ann.estetiCanina.dtos.request.PagoRequest;
import com.ann.estetiCanina.dtos.response.PagoResponse;
import com.ann.estetiCanina.service.interfaces.IPagoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {
    private final IPagoService pagoService;

    public PagoController(IPagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<PagoResponse> registrar(@RequestBody @Valid PagoRequest dto) {
        return ResponseEntity.ok(pagoService.registrarPago(dto));
    }

    @GetMapping
    public ResponseEntity<List<PagoResponse>> listar() {
        return ResponseEntity.ok(pagoService.listarPagos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.obtenerPagoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }
}
