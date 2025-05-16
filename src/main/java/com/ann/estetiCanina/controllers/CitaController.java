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

import com.ann.estetiCanina.dtos.request.CitaRequest;
import com.ann.estetiCanina.dtos.response.CitaResponse;
import com.ann.estetiCanina.service.interfaces.ICitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {
    private final ICitaService citaService;

    public CitaController(ICitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public ResponseEntity<CitaResponse> registrarCita(@RequestBody @Valid CitaRequest dto) {
        return ResponseEntity.ok(citaService.registrarCita(dto));
    }

    @GetMapping
    public ResponseEntity<List<CitaResponse>> listarCitas() {
        return ResponseEntity.ok(citaService.listarCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponse> obtenerCitaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.findCitaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }

    /*
        {
            "mascota_id": 1,
            "empleado_id": 2,
            "fecha": "2025-05-17",
            "hora_inicio": "10:00",
            "hora_fin": "11:00",
            "estado": "PENDIENTE",
            "observaciones": "Primera visita"
        }
      
    */
}
