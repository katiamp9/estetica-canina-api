package com.ann.estetiCanina.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmpleadoRequest {

    @NotBlank
    @Size(max = 80)
    private String nombre;

    @NotBlank
    @Size(max = 100)
    @Email
    private String correo;

    @NotBlank
    @Size(max = 15)
    private String telefono;

    @NotBlank
    @Size(max = 30)
    private String usuario;

    @NotBlank
    @Size(max = 100)
    private String contrasena;

    private Long empleoId; // Solo enviamos el id del empleo para relacionar

    public EmpleadoRequest() {
    }

    public EmpleadoRequest(String nombre, String correo, String telefono, String usuario, String contrasena, Long empleoId) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.empleoId = empleoId;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Long getEmpleoId() {
        return empleoId;
    }

    public void setEmpleoId(Long empleoId) {
        this.empleoId = empleoId;
    }
}
