package com.ann.estetiCanina.service.impls;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import java.util.List;

import com.ann.estetiCanina.dtos.request.CitaRequest;
import com.ann.estetiCanina.dtos.response.CitaResponse;
import com.ann.estetiCanina.models.Cita;
import com.ann.estetiCanina.models.Empleado;
import com.ann.estetiCanina.models.Mascota;
import com.ann.estetiCanina.repository.CitaRepository;
import com.ann.estetiCanina.service.interfaces.ICitaService;

@Service
public class CitaServiceImpl implements ICitaService{
    private final CitaRepository citaRepo;
    //private final MascotaRepository mascotaRepo;
    //private final EmpleadoRepository empleadoRepo;

    public CitaServiceImpl(CitaRepository citaRepo /*, MascotaRepository mascotaRepo, EmpleadoRepository empleadoRepo*/) {
        this.citaRepo = citaRepo;
        /*this.mascotaRepo = mascotaRepo;
        this.empleadoRepo = empleadoRepo;*/
    }

    @Override
    public CitaResponse registrarCita(CitaRequest dto) {
        //Mascota mascota = mascotaRepo.findById((long) dto.getMascota_id())
                //.orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        //Empleado empleado = empleadoRepo.findById((long) dto.getEmpleado_id())
                //.orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        Cita cita = new Cita();
        //cita.setMascota(mascota);
        //cita.setEmpleado(empleado);
        cita.setFecha(dto.getFecha());
        cita.setHora_inicio(dto.getHora_inicio());
        cita.setHora_fin(dto.getHora_fin());
        cita.setEstado(dto.getEstado());
        cita.setObservaciones(dto.getObservaciones());

        Cita guardada = citaRepo.save(cita);

        return mapToResponse(guardada);
    }

    @Override
    public List<CitaResponse> listarCitas() {
        return citaRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CitaResponse findCitaPorId(Long id) {
        Cita cita = citaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return mapToResponse(cita);
    }

    @Override
    public void eliminarCita(Long id) {
        if (!citaRepo.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: cita no encontrada");
        }
        citaRepo.deleteById(id);
    }

    private CitaResponse mapToResponse(Cita cita) {
        CitaResponse res = new CitaResponse();
        res.setId_cita(cita.getId_cita());
        res.setNombreMascota(cita.getMascota().getNombre());
        res.setNombreEmpleado(cita.getEmpleado().getNombre());
        res.setEstado(cita.getEstado());
        res.setObservaciones(cita.getObservaciones());
        return res;
    }
}
