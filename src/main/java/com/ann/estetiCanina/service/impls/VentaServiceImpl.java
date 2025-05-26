package com.ann.estetiCanina.service.impls;


import com.ann.estetiCanina.dtos.request.VentaRequest;
import com.ann.estetiCanina.dtos.response.VentaResponse;
import com.ann.estetiCanina.models.*;
import com.ann.estetiCanina.repository.*;
import com.ann.estetiCanina.service.interfaces.IVentaService;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements IVentaService {

    private final VentaRepository ventaRepo;
     private final EmpleadoRepository empleadoRepo;

    public VentaServiceImpl(VentaRepository ventaRepo , EmpleadoRepository empleadoRepo ) {
        this.ventaRepo = ventaRepo;
         this.empleadoRepo = empleadoRepo;
    }

    @Override
    public VentaResponse registrarVenta(VentaRequest dto) {
        
        Empleado empleado = empleadoRepo.findById(dto.getEmpleado_id())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    

        Venta venta = new Venta();
         venta.setEmpleado(empleado);
        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());

        Venta guardado = ventaRepo.save(venta);
        return mapToResponse(guardado);
    }

    @Override
    public List<VentaResponse> listarVentas() {
        return ventaRepo.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public VentaResponse obtenerVentaPorId(Long id) {
        Venta venta = ventaRepo.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        return mapToResponse(venta);
    }

    @Override
    public void eliminarVenta(Long id) {
        if (!ventaRepo.existsById(id)) {
            throw new RuntimeException("Venta no encontrada");
        }
        ventaRepo.deleteById(id);
    }

    private VentaResponse mapToResponse(Venta venta) {
        VentaResponse dto = new VentaResponse();
        dto.setId(venta.getId_venta());
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());
        return dto;
    }
}
