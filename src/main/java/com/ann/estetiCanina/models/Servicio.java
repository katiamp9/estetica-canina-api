package com.ann.estetiCanina.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long id_servicio;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    @DecimalMin(value = "0.00")
    @Column(name = "precio_base", precision = 7, scale = 2)
    private BigDecimal precio_base;

    @NotBlank
    @Size(max = 20)
    @Column(name = "tipo_tamano")
    private String tipo_tamano;

    public Servicio() {
    }

    public Servicio(Long id_servicio, String nombre, String descripcion, BigDecimal precio_base, String tipo_tamano) {
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

