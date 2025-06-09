package com.ann.estetiCanina.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmpleoRequest {

    @NotBlank
    @Size(max = 40)
    private String titulo;

    @NotBlank
    @Size(max = 200)
    private String descripcion;

    public EmpleoRequest() {
    }

    public EmpleoRequest(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

