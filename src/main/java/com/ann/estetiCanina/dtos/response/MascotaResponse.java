package com.ann.estetiCanina.dtos.response;

import java.time.LocalDate;

public class MascotaResponse {

    private Long id_mascota;
    private String nombre;
    private String raza;
    private String sexo;
    private LocalDate fecha_nacimiento;
    private Long clienteId;

    public MascotaResponse() {
    }

    public MascotaResponse(Long id_mascota, String nombre, String raza, String sexo, LocalDate fecha_nacimiento, Long clienteId) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.clienteId = clienteId;
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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

}

