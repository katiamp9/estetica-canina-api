package com.ann.estetiCanina.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ann.estetiCanina.dtos.request.TurnoRequest;
import com.ann.estetiCanina.dtos.response.TurnoResponse;
import com.ann.estetiCanina.service.interfaces.ITurnoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "*")
public class TurnoController {
    private final ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    // POST /api/turnos
    @PostMapping
    public ResponseEntity<TurnoResponse> registrar(@RequestBody @Valid TurnoRequest dto) {
        return ResponseEntity.ok(turnoService.registrarTurno(dto));
    }

    // GET /api/turnos
    @GetMapping
    public ResponseEntity<List<TurnoResponse>> listar() {
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    // GET /api/turnos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TurnoResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(turnoService.obtenerTurnoPorId(id));
    }

    // DELETE /api/turnos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        turnoService.eliminarTurno(id);
        return ResponseEntity.noContent().build();
    }
}
