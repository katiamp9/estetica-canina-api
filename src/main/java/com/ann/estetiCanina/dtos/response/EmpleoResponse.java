package com.ann.estetiCanina.dtos.response;

public class EmpleoResponse {

    private Long id_empleo;
    private String titulo;
    private String descripcion;

    public EmpleoResponse() {
    }

    public EmpleoResponse(Long id_empleo, String titulo, String descripcion) {
        this.id_empleo = id_empleo;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId_empleo() {
        return id_empleo;
    }

    public void setId_empleo(Long id_empleo) {
        this.id_empleo = id_empleo;
    }

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

