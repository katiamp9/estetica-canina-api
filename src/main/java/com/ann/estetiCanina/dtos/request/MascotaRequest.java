package com.ann.estetiCanina.dtos.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class MascotaRequest {

    @NotBlank
    @Size(max = 50)
    private String nombre;

    @NotBlank
    @Size(max = 40)
    private String raza;

    @NotBlank
    @Size(max = 10)
    private String sexo;

    @Past
    private LocalDate fecha_nacimiento;

    @NotNull
    private Long clienteId;

    public MascotaRequest( String nombre,  String raza, String sexo, LocalDate fecha_nacimiento, Long clienteId) {
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.clienteId = clienteId;
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
