package com.ann.estetiCanina.dtos.response;


import java.math.BigDecimal;

public class DetalleVentaResponse {

    private Long id;
    private Long ventaId;
    private Long citaId;
    private Long servicioId;
    private BigDecimal precioUnitario;
    private int cantidad;
    private BigDecimal subtotal;

    public DetalleVentaResponse() {
    }

    public DetalleVentaResponse(Long id, Long ventaId, Long citaId, Long servicioId,
                                BigDecimal precioUnitario, int cantidad, BigDecimal subtotal) {
        this.id = id;
        this.ventaId = ventaId;
        this.citaId = citaId;
        this.servicioId = servicioId;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
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

    public Long getCitaId() {
        return citaId;
    }

    public void setCitaId(Long citaId) {
        this.citaId = citaId;
    }

    public Long getServicioId() {
        return servicioId;
    }

    public void setServicioId(Long servicioId) {
        this.servicioId = servicioId;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
