package com.example.API_Concesionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table (name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String email;

    @Column
    private String telefono;

    @Column
    private String rol;

    @Column (name = "fecha_contratacion")
    private Timestamp fechaContratacion;

    @Column
    private boolean activo;


    public Empleado(String nombre, String apellidos, String email, String telefono, String rol, Timestamp fechaContratacion, boolean activo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
        this.fechaContratacion = fechaContratacion;
        this.activo = activo;
    }

    public Empleado() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRol() {
        return rol;
    }

    public Timestamp getFechaContratacion() {
        return fechaContratacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setFechaContratacion(Timestamp fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
