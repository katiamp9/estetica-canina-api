package com.ann.estetiCanina.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = "correo")
})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String nombre;

    @NotBlank
    @Size(max=50)
    @Email
    private String correo;

    @NotBlank
    @Size(max=10)
    private String telefono;

    @NotBlank
    @Size(max=200)
    private String direccion;

  public Cliente() {
  }

  public Cliente(Long id, String nombre, String correo, String telefono, String direccion) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
    this.telefono = telefono;
    this.direccion = direccion;
  }

  public Cliente(String nombre, String correo, String telefono, String direccion) {
    this.nombre = nombre;
    this.correo = correo;
    this.telefono = telefono;
    this.direccion = direccion;
}


  //Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
}