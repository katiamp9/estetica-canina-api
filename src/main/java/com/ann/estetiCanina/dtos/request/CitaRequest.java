package com.ann.estetiCanina.dtos.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CitaRequest {
    @NotNull
    private Long mascota_id;

    @NotNull
    private Long empleado_id;

    @NotBlank
    private LocalDate fecha;

    @NotBlank
    private LocalTime hora_inicio;

    @NotBlank
    private LocalTime hora_fin;

    @NotBlank
    @Size(max = 20)
    private String estado;

    @Size(max = 200)
    private String observaciones;

    public CitaRequest( Long mascota_id,  Long empleado_id, LocalDate fecha, LocalTime hora_inicio,  LocalTime hora_fin, String estado, String observaciones) {
        this.mascota_id = mascota_id;
        this.empleado_id = empleado_id;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.estado = estado;
        this.observaciones = observaciones;
    }


    public Long getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(Long mascota_id) {
        this.mascota_id = mascota_id;
    }

    public Long getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(Long empleado_id) {
        this.empleado_id = empleado_id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
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
