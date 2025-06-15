package com.ann.estetiCanina.controllers;

import com.ann.estetiCanina.dtos.request.EmpleadoRequest;
import com.ann.estetiCanina.dtos.response.EmpleadoResponse;
import com.ann.estetiCanina.service.interfaces.IEmpleadoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/registro")
    public EmpleadoResponse registrarEmpleado(@Valid @RequestBody EmpleadoRequest request) {
        return empleadoService.registrarEmpleado(request);
    }

    @GetMapping("/{id}")
    public EmpleadoResponse getEmpleadoById(@PathVariable Long id) {
        return empleadoService.getEmpleadoById(id);
    }

    @GetMapping
    public List<EmpleadoResponse> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/buscar")
    public List<EmpleadoResponse> buscarPorNombre(@RequestParam String nombre) {
        return empleadoService.findEmpleadoByNombre(nombre);
    }

    @PutMapping("/{id}")
    public EmpleadoResponse actualizarEmpleado(@PathVariable Long id, @Valid @RequestBody EmpleadoRequest request) {
        return empleadoService.updateEmpleado(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
    }
}
