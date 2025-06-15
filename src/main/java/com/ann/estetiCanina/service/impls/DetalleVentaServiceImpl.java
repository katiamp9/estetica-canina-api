package com.ann.estetiCanina.service.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ann.estetiCanina.dtos.request.DetalleVentaRequest;
import com.ann.estetiCanina.dtos.response.DetalleVentaResponse;
import com.ann.estetiCanina.models.Cita;
import com.ann.estetiCanina.models.Servicio;
import com.ann.estetiCanina.models.Venta;
import com.ann.estetiCanina.models.DetalleVenta;
import com.ann.estetiCanina.repository.CitaRepository;
import com.ann.estetiCanina.repository.ServicioRepository;
import com.ann.estetiCanina.repository.VentaRepository;
import com.ann.estetiCanina.repository.DetalleVentaRepository;
import com.ann.estetiCanina.service.interfaces.IDetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepo;
    private final VentaRepository ventaRepo;
    private final CitaRepository citaRepo;
    private final ServicioRepository servicioRepo;

    public DetalleVentaServiceImpl(
            DetalleVentaRepository detalleVentaRepo,
            VentaRepository ventaRepo,
            CitaRepository citaRepo,
            ServicioRepository servicioRepo) {
        this.detalleVentaRepo = detalleVentaRepo;
        this.ventaRepo = ventaRepo;
        this.citaRepo = citaRepo;
        this.servicioRepo = servicioRepo;
    }

    @Override
    public DetalleVentaResponse registrarDetalle(DetalleVentaRequest dto) {
        Venta venta = ventaRepo.findById(dto.getVenta_id())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        Cita cita = citaRepo.findById(dto.getCita_id())
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        Servicio servicio = servicioRepo.findById(dto.getServicio_id())
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        DetalleVenta detalle = new DetalleVenta();
        detalle.setVenta(venta);
        detalle.setCita(cita);
        detalle.setServicio(servicio);
        detalle.setPrecio_unitario(dto.getPrecio_unitario());
        detalle.setCantidad(dto.getCantidad());
        detalle.setSubtotal(dto.getSubtotal());

        DetalleVenta guardado = detalleVentaRepo.save(detalle);
        return mapToResponse(guardado);
    }

    @Override
    public List<DetalleVentaResponse> listarDetalles() {
        return detalleVentaRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DetalleVentaResponse obtenerDetallePorId(Long id) {
        DetalleVenta detalle = detalleVentaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
        return mapToResponse(detalle);
    }

    @Override
    public void eliminarDetalle(Long id) {
        if (!detalleVentaRepo.existsById(id)) {
            throw new RuntimeException("Detalle no encontrado");
        }
        detalleVentaRepo.deleteById(id);
    }

    private DetalleVentaResponse mapToResponse(DetalleVenta detalle) {
        return new DetalleVentaResponse(
                detalle.getId_detalle(),
                detalle.getVenta().getId_venta(),
                detalle.getCita().getId_cita(),
                detalle.getServicio().getId_servicio(),
                detalle.getPrecio_unitario(),
                detalle.getCantidad(),
                detalle.getSubtotal()
        );
    }
}

