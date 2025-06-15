package com.ann.estetiCanina.dtos.request;

import java.math.BigDecimal;


import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;

public class DetalleVentaRequest {
    
    @NotNull
    private long venta_id;

    @NotNull
    private long cita_id;

    @NotNull
    private long servicio_id;
    
    @DecimalMin("0.00")
    private BigDecimal precio_unitario;

    @NotNull
    private int cantidad;
    
    @DecimalMin("0.00")
    private BigDecimal subtotal;



    public DetalleVentaRequest( long venta_id,  long cita_id, long servicio_id,
            BigDecimal precio_unitario,  int cantidad,
             BigDecimal subtotal) {
        this.venta_id = venta_id;
        this.cita_id = cita_id;
        this.servicio_id = servicio_id;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }



    public long getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(long venta_id) {
        this.venta_id = venta_id;
    }

    public long getCita_id() {
        return cita_id;
    }

    public void setCita_id(long cita_id) {
        this.cita_id = cita_id;
    }

    public long getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(long servicio_id) {
        this.servicio_id = servicio_id;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
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
 
