package com.ann.estetiCanina.dtos.response;

public class MascotaResponse {
    private Long id_mascota;
    private String nombre;
    private String raza;
    private String sexo;
    private String nombreCliente;

    public MascotaResponse(){}
    
    public MascotaResponse(Long id_mascota, String nombre, String raza, String sexo, String nombreCliente) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.nombreCliente = nombreCliente;
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
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
}
