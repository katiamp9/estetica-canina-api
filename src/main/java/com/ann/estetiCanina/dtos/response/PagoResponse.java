package com.ann.estetiCanina.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagoResponse {

    private Long id;
    private Long ventaId;
    private BigDecimal monto;
    private String tipoPago;
    private LocalDate fecha;

    public PagoResponse() {
    }

    public PagoResponse(Long id, Long ventaId, BigDecimal monto, String tipoPago, LocalDate fecha) {
        this.id = id;
        this.ventaId = ventaId;
        this.monto = monto;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVentaId() {
        return ventaId;
    }

    public void setVentaId(Long ventaId) {
        this.ventaId = ventaId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
