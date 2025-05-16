package com.ann.estetiCanina.dtos.response;

import java.math.BigDecimal;

public class ServicioResponse {
    private Long id_servicio;
    private String nombre;
    private String descripcion;
    private BigDecimal precio_base;
    private String tipo_tamano;

    
    public ServicioResponse(){}
    
    public ServicioResponse(Long id_servicio, String nombre, String descripcion, BigDecimal precio_base,
            String tipo_tamano) {
        this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_base = precio_base;
        this.tipo_tamano = tipo_tamano;
    }

    public Long getId_servicio() {
        return id_servicio;
    }
    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
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
