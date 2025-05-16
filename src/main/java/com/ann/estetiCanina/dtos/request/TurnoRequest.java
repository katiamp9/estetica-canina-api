package com.ann.estetiCanina.dtos.request;

import java.time.LocalTime;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TurnoRequest {
    @NotNull
    private Long empleadoId;

    @NotBlank
    @Size(max = 10)
    private String dia_semana;

    @NotNull
    private LocalTime hora_inicio;

    @NotNull
    private LocalTime hora_fin;

    public TurnoRequest( Long empleadoId, String dia_semana, LocalTime hora_inicio, LocalTime hora_fin) {
        this.empleadoId = empleadoId;
        this.dia_semana = dia_semana;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
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
