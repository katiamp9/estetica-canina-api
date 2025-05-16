package com.ann.estetiCanina.service.impls;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import java.util.List;
import com.ann.estetiCanina.dtos.request.TurnoRequest;
import com.ann.estetiCanina.dtos.response.TurnoResponse;
import com.ann.estetiCanina.models.Empleado;
import com.ann.estetiCanina.models.Turno;
import com.ann.estetiCanina.repository.TurnoRepository;
import com.ann.estetiCanina.service.interfaces.ITurnoService;

@Service
public class TurnoServiceImpl implements ITurnoService{
    private final TurnoRepository turnoRepo;
    //private final EmpleadoRepository empleadoRepo;

    public TurnoServiceImpl(TurnoRepository turnoRepo/*, EmpleadoRepository empleadoRepo*/) {
        this.turnoRepo = turnoRepo;
      //  this.empleadoRepo = empleadoRepo;
    }

    @Override
    public TurnoResponse registrarTurno(TurnoRequest dto) {
       /* Empleado empleado = empleadoRepo.findById(dto.getEmpleadoId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));*/

        Turno turno = new Turno();
        //turno.setEmpleado(empleado);
        turno.setDia_semana(dto.getDia_semana());
        turno.setHora_inicio(dto.getHora_inicio());
        turno.setHora_fin(dto.getHora_fin());

        Turno guardado = turnoRepo.save(turno);
        return mapToResponse(guardado);
    }

    @Override
    public List<TurnoResponse> listarTurnos() {
        return turnoRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TurnoResponse obtenerTurnoPorId(Long id) {
        Turno turno = turnoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        return mapToResponse(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        if (!turnoRepo.existsById(id)) {
            throw new RuntimeException("Turno no encontrado");
        }
        turnoRepo.deleteById(id);
    }

    private TurnoResponse mapToResponse(Turno turno) {
        TurnoResponse dto = new TurnoResponse();
        dto.setId_turno(turno.getId_turno());
        dto.setNombreEmpleado(turno.getEmpleado().getNombre());
        dto.setDia_semana(turno.getDia_semana());
        dto.setHora_inicio(turno.getHora_inicio());
        dto.setHora_fin(turno.getHora_fin());
        return dto;
    }
}
