package com.ann.estetiCanina.dtos.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PagoRequest {
    
    @NotNull
    private long venta_id;

    @DecimalMin("0.00")
    private BigDecimal monto;
    
    @NotBlank
    private String tipo_pago;
    
    @NotNull
    private LocalDate fecha;

    public PagoRequest( long venta_id,  BigDecimal monto, String tipo_pago,
             LocalDate fecha) {
        this.venta_id = venta_id;
        this.monto = monto;
        this.tipo_pago = tipo_pago;
        this.fecha = fecha;
    }

    public long getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(long venta_id) {
        this.venta_id = venta_id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


}
