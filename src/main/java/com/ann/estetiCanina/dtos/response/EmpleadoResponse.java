package com.ann.estetiCanina.dtos.response;

public class EmpleadoResponse {

    private Long id_empleado;
    private String nombre;
    private String correo;
    private String telefono;
    private String usuario;
    private Long empleoId;

    public EmpleadoResponse() {
    }

    public EmpleadoResponse(Long id_empleado, String nombre, String correo, String telefono, String usuario, Long empleoId) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.empleoId = empleoId;
    }

    // Getters y Setters

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

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

    public Long getEmpleoId() {
        return empleoId;
    }

    public void setEmpleoId(Long empleoId) {
        this.empleoId = empleoId;
    }

}
