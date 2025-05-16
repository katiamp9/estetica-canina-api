package com.ann.estetiCanina.service.impls;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ann.estetiCanina.dtos.request.ServicioRequest;
import com.ann.estetiCanina.dtos.response.ServicioResponse;
import com.ann.estetiCanina.models.Servicio;
import com.ann.estetiCanina.repository.ServicioRepository;
import com.ann.estetiCanina.service.interfaces.IServicioService;

@Service
public class ServicioServiceImpl implements IServicioService{
     private final ServicioRepository servicioRepo;

    public ServicioServiceImpl(ServicioRepository servicioRepo) {
        this.servicioRepo = servicioRepo;
    }

    @Override
    public ServicioResponse registrarServicio(ServicioRequest dto) {
        Servicio servicio = new Servicio();
        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio_base(dto.getPrecio_base());
        servicio.setTipo_tamano(dto.getTipo_tamano());

        Servicio guardado = servicioRepo.save(servicio);
        return mapToResponse(guardado);
    }

    @Override
    public List<ServicioResponse> listarServicios() {
        return servicioRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioResponse obtenerServicioPorId(Long id) {
        Servicio servicio = servicioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        return mapToResponse(servicio);
    }

    @Override
    public void eliminarServicio(Long id) {
        if (!servicioRepo.existsById(id)) {
            throw new RuntimeException("Servicio no encontrado");
        }
        servicioRepo.deleteById(id);
    }

    private ServicioResponse mapToResponse(Servicio servicio) {
        ServicioResponse res = new ServicioResponse();
        res.setId_servicio(servicio.getId_servicio());
        res.setNombre(servicio.getNombre());
        res.setDescripcion(servicio.getDescripcion());
        res.setPrecio_base(servicio.getPrecio_base());
        res.setTipo_tamano(servicio.getTipo_tamano());
        return res;
    }
}
