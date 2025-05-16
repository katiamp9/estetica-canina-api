package com.ann.estetiCanina.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long id_mascota;

    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Size(max = 40)
    @Column(name = "raza")
    private String raza;

    @NotBlank
    @Size(max = 10)
    @Column(name = "sexo")
    private String sexo;

    @Past
    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombre, String raza, String sexo, LocalDate fecha_nacimiento, Cliente cliente) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.cliente = cliente;
    }

    public Long getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(Long id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}


