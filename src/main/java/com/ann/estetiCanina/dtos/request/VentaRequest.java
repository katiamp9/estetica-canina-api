package com.ann.estetiCanina.dtos.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;

public class VentaRequest {
   
    
    @NotNull
    private long empleado_id;
    
    @NotNull
    private LocalDate fecha;
    
     @DecimalMin("0.00")
    private BigDecimal total;
    
    public VentaRequest( long empleado_id,  LocalDate fecha,  BigDecimal total) {
        
        this.empleado_id = empleado_id;
        this.fecha = fecha;
        this.total = total;
    }


  
    public long getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(long empleado_id) {
        this.empleado_id = empleado_id;
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
