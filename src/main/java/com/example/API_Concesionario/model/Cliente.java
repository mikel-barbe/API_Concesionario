package com.example.API_Concesionario.model;


import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tipo;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String documento;

    @Column
    private String email;

    @Column
    private String telefono;

    @Column
    private String direccion;

    @Column
    private String ciudad;

    @Column
    private String cp;

    @Column
    private String pais;

    @Column(name = "fecha_alta")
    private Timestamp fechaAlta;

    public Cliente(String tipo, String nombre, String apellidos, String documento, String email, String telefono, String direccion, String ciudad, String cp, String pais, Timestamp fechaAlta) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.cp = cp;
        this.pais = pais;
        this.fechaAlta = fechaAlta;
    }
    public Cliente(){

    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCp() {
        return cp;
    }

    public String getPais() {
        return pais;
    }

    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}