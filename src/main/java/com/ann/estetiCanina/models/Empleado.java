package com.ann.estetiCanina.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleados",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "correo"),
           @UniqueConstraint(columnNames = "usuario")
})
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id_empleado;

    @NotBlank
    @Size(max = 80)
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Size(max = 100)
    @Email
    @Column(name = "correo")
    private String correo;

    @NotBlank
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;

    @NotBlank
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;

    @NotBlank
    @Size(max = 100)
    @Column(name = "contrasena")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "empleo_id", nullable = false)
    private Empleo empleo;

    public Empleado() {
    }

    public Empleado(Long id_empleado, String nombre, String correo, String telefono, String usuario, String contrasena, Empleo empleo) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.empleo = empleo;
    }

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Empleo getEmpleo() {
        return empleo;
    }

    public void setEmpleo(Empleo empleo) {
        this.empleo = empleo;
    }
}

