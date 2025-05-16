package com.ann.estetiCanina.dtos.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

public class ServicioRequest {
    @NotBlank
    @Size(max = 50)
    private String nombre;

    @NotBlank
    @Size(max = 200)
    private String descripcion;

    @DecimalMin("0.00")
    private BigDecimal precio_base;

    @NotBlank
    @Size(max = 20)
    private String tipo_tamano;

    public ServicioRequest(String nombre, String descripcion, BigDecimal precio_base, String tipo_tamano) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_base = precio_base;
        this.tipo_tamano = tipo_tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(BigDecimal precio_base) {
        this.precio_base = precio_base;
    }

    public String getTipo_tamano() {
        return tipo_tamano;
    }

    public void setTipo_tamano(String tipo_tamano) {
        this.tipo_tamano = tipo_tamano;
    }

    
    

}
