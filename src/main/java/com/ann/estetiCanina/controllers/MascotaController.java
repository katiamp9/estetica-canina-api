package com.ann.estetiCanina.controllers;

import com.ann.estetiCanina.dtos.request.MascotaRequest;
import com.ann.estetiCanina.dtos.response.MascotaResponse;
import com.ann.estetiCanina.service.interfaces.IMascotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final IMascotaService mascotaService;

    public MascotaController(IMascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    // Crear una nueva mascota
    @PostMapping
    public ResponseEntity<MascotaResponse> crearMascota(@RequestBody MascotaRequest request) {
        MascotaResponse response = mascotaService.registrarMascota(request);
        return ResponseEntity.ok(response);
    }

    // Obtener todas las mascotas
    @GetMapping
    public ResponseEntity<List<MascotaResponse>> obtenerTodas() {
        return ResponseEntity.ok(mascotaService.obtenerTodasLasMascotas());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.obtenerMascotaPorId(id));
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return ResponseEntity.noContent().build(); // 204 sin contenido
    }

    // Actualizar mascota
    @PutMapping("/{id}")
    public ResponseEntity<MascotaResponse> actualizarMascota(@PathVariable Long id, @RequestBody MascotaRequest request) {
        return ResponseEntity.ok(mascotaService.actualizarMascota(id, request));
    }

    // Listar mascotas por cliente
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<MascotaResponse>> obtenerPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(mascotaService.obtenerMascotasPorCliente(clienteId));
    }

    // Buscar mascotas por nombre
    @GetMapping("/buscar")
    public ResponseEntity<List<MascotaResponse>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(mascotaService.buscarMascotasPorNombre(nombre));
    }
}
