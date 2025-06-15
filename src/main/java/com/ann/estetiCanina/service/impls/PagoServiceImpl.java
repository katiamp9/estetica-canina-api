package com.ann.estetiCanina.service.impls;



import com.ann.estetiCanina.dtos.request.PagoRequest;
import com.ann.estetiCanina.dtos.response.PagoResponse;
import com.ann.estetiCanina.models.*;
import com.ann.estetiCanina.repository.*;
import com.ann.estetiCanina.service.interfaces.IPagoService;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements IPagoService {

    private final PagosRepository pagoRepo;
    private final VentaRepository ventaRepo;

    public PagoServiceImpl(PagosRepository pagoRepo, VentaRepository ventaRepo) {
        this.pagoRepo = pagoRepo;
        this.ventaRepo = ventaRepo;
    }

    @Override
    public PagoResponse registrarPago(PagoRequest dto) {
        Venta venta = ventaRepo.findById(dto.getVenta_id())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        Pago pago = new Pago();
        pago.setVenta(venta);
        pago.setMonto(dto.getMonto());
        pago.setTipo_pago(dto.getTipo_pago());
        pago.setFecha(dto.getFecha());

        Pago guardado = pagoRepo.save(pago);
        return mapToResponse(guardado);
    }

    @Override
    public List<PagoResponse> listarPagos() {
        return pagoRepo.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public PagoResponse obtenerPagoPorId(Long id) {
        Pago pago = pagoRepo.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return mapToResponse(pago);
    }

    @Override
    public void eliminarPago(Long id) {
        if (!pagoRepo.existsById(id)) {
            throw new RuntimeException("Pago no encontrado");
        }
        pagoRepo.deleteById(id);
    }

    private PagoResponse mapToResponse(Pago pago) {
        PagoResponse dto = new PagoResponse();
        dto.setId(pago.getId_pago());
        dto.setVentaId(pago.getVenta().getId_venta());
        dto.setMonto(pago.getMonto());
        dto.setTipoPago(pago.getTipo_pago());
        dto.setFecha(pago.getFecha());
        return dto;
    }
}
