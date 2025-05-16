package com.ann.estetiCanina.dtos.response;

import java.time.LocalTime;

import com.ann.estetiCanina.models.Turno;

public class TurnoResponse {
    private Long id_turno;
    private String nombreEmpleado;
    private String dia_semana;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;

    public TurnoResponse(){}

    public TurnoResponse(Long id_turno, String nombreEmpleado, String dia_semana, LocalTime hora_inicio,
        LocalTime hora_fin) {
        this.id_turno = id_turno;
        this.nombreEmpleado = nombreEmpleado;
        this.dia_semana = dia_semana;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public Long getId_turno() {
        return id_turno;
    }
    public void setId_turno(Long id_turno) {
        this.id_turno = id_turno;
    }
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
    public String getDia_semana() {
        return dia_semana;
    }
    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
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

}
