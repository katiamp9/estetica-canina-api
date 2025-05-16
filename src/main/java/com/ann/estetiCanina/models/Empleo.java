package com.ann.estetiCanina.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleos")
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleo")
    private Long id_empleo;

    @NotBlank
    @Size(max = 40)
    @Column(name = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    public Empleo() {
    }

    public Empleo(Long id_empleo, String titulo, String descripcion) {
        this.id_empleo = id_empleo;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

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
