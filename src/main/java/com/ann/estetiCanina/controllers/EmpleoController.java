package com.ann.estetiCanina.controllers;

import com.ann.estetiCanina.dtos.request.EmpleoRequest;
import com.ann.estetiCanina.dtos.response.EmpleoResponse;
import com.ann.estetiCanina.service.interfaces.IEmpleoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/empleos")
public class EmpleoController {

    @Autowired
    private IEmpleoService empleoService;

    @PostMapping("/registro")
    public EmpleoResponse registrar(@Valid @RequestBody EmpleoRequest request) {
        return empleoService.registrarEmpleo(request);
    }

    @GetMapping
    public List<EmpleoResponse> listar() {
        return empleoService.getAllEmpleos();
    }

    @GetMapping("/{id}")
    public EmpleoResponse obtener(@PathVariable Long id) {
        return empleoService.getEmpleoById(id);
    }

    @PutMapping("/{id}")
    public EmpleoResponse actualizar(@PathVariable Long id, @Valid @RequestBody EmpleoRequest request) {
        return empleoService.updateEmpleo(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        empleoService.deleteEmpleo(id);
    }
}
