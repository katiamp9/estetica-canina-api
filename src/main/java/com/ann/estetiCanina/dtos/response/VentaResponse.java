package com.ann.estetiCanina.dtos.response;



import java.math.BigDecimal;
import java.time.LocalDate;

public class VentaResponse {

    private Long id;
    private Long empleadoId;
    private LocalDate fecha;
    private BigDecimal total;

    public VentaResponse() {
    }

    public VentaResponse(Long id, Long empleadoId, LocalDate fecha, BigDecimal total) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.fecha = fecha;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
