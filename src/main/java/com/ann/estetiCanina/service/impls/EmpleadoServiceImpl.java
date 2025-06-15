package com.ann.estetiCanina.service.impls;

import com.ann.estetiCanina.dtos.request.EmpleadoRequest;
import com.ann.estetiCanina.dtos.response.EmpleadoResponse;
import com.ann.estetiCanina.models.Empleado;
import com.ann.estetiCanina.models.Empleo;
import com.ann.estetiCanina.repository.EmpleadoRepository;
import com.ann.estetiCanina.repository.EmpleoRepository;
import com.ann.estetiCanina.service.interfaces.IEmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleoRepository empleoRepository;

    @Override
    public EmpleadoResponse registrarEmpleado(EmpleadoRequest request) {
        Empleo empleo = empleoRepository.findById(request.getEmpleoId())
                .orElseThrow(() -> new RuntimeException("Empleo no encontrado con ID: " + request.getEmpleoId()));

        Empleado empleado = new Empleado();
        empleado.setNombre(request.getNombre());
        empleado.setCorreo(request.getCorreo());
        empleado.setTelefono(request.getTelefono());
        empleado.setUsuario(request.getUsuario());
        empleado.setContrasena(request.getContrasena());
        empleado.setEmpleo(empleo);

        Empleado guardado = empleadoRepository.save(empleado);
        return toResponse(guardado);
    }

    @Override
    public EmpleadoResponse getEmpleadoById(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
        return toResponse(empleado);
    }

    @Override
    public List<EmpleadoResponse> getAllEmpleados() {
        return empleadoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoResponse> findEmpleadoByNombre(String nombre) {
        return empleadoRepository.findByNombre(nombre).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoResponse updateEmpleado(Long id, EmpleadoRequest request) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));

        Empleo empleo = empleoRepository.findById(request.getEmpleoId())
                .orElseThrow(() -> new RuntimeException("Empleo no encontrado con ID: " + request.getEmpleoId()));

        empleado.setNombre(request.getNombre());
        empleado.setCorreo(request.getCorreo());
        empleado.setTelefono(request.getTelefono());
        empleado.setUsuario(request.getUsuario());
        empleado.setContrasena(request.getContrasena());
        empleado.setEmpleo(empleo);

        Empleado actualizado = empleadoRepository.save(empleado);
        return toResponse(actualizado);
    }

    @Override
    public void deleteEmpleado(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new RuntimeException("Empleado no encontrado con ID: " + id);
        }
        empleadoRepository.deleteById(id);
    }

    // Método auxiliar para mapear a DTO response
    private EmpleadoResponse toResponse(Empleado empleado) {
        return new EmpleadoResponse(
                empleado.getId_empleado(),
                empleado.getNombre(),
                empleado.getCorreo(),
                empleado.getTelefono(),
                empleado.getUsuario(),
                empleado.getEmpleo().getId_empleo()
        );
    }
}
