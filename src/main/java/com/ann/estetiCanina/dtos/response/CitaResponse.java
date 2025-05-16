package com.ann.estetiCanina.dtos.response;

public class CitaResponse {
    private Long id_cita;
    private String nombreMascota;
    private String nombreEmpleado;
    private String estado;
    private String observaciones;

    public CitaResponse() {
    }

    public CitaResponse(Long id_cita, String nombreMascota, String nombreEmpleado, String estado,
            String observaciones) {
        this.id_cita = id_cita;
        this.nombreMascota = nombreMascota;
        this.nombreEmpleado = nombreEmpleado;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Long getId_cita() {
        return id_cita;
    }

    public void setId_cita(Long id_cita) {
        this.id_cita = id_cita;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
